N = int(input())
cows = input()

if '1' not in cows:
    print(0)
    exit()

interval_lengths = []
count = 0

for i in range(N):
    if cows[i] == '0' and count > 0:
        interval_lengths.append(count)
        count = 0
    elif cows[i] == '1':
        count += 1

if count > 0:
    interval_lengths.append(count)

# Number of intervals
L = len(interval_lengths)

leftZero = cows[0] == '0'
rightZero = cows[N-1] == '0'

max_days = min(interval_lengths[0], interval_lengths[L-1])-1  # using formula max days = (length of interval - 1) / 2
if leftZero:
    max_days = min(max_days, (interval_lengths[0]-1)//2)
if rightZero:
    max_days = min(max_days, (interval_lengths[L-1]-1)//2)

for i in range(1, L-1):
    max_days = min(max_days, (interval_lengths[i] - 1)//2)
print(max_days)
count = 0
for i in range(L):
    count += interval_lengths[i] // (2 * max_days + 1)
    if interval_lengths[i] % (2 * max_days + 1) != 0:
        count += 1

print(count)