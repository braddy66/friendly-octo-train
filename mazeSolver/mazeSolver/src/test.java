class test{
    public static void main(String [] args){
        Maze m = new Maze();
        m.loadMaze("maze-2");
        System.out.println(m.toString());
        MyStack idk = new MyStack();
        idk.push(new Square(1,1,1));
        System.out.println(idk.pop());
        System.out.println(idk.pop());
        
    }
}
