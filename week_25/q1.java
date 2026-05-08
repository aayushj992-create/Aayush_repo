package week_25;

import java.util.LinkedList;

public class q1
{
    private LinkedList<String> playlist = new LinkedList<>();

    public void addMusic(String name)
    {
        playlist.add(name);
    }

    public void begining(String name)
    {
        playlist.addFirst(name);
    }

    public void last(String name)
    {
        playlist.addLast(name);
    }

    public void second()
    {
        if (playlist.size() > 1) {
            playlist.remove(1);
        }
    }

    public void printList()
    {
        for(String a : playlist)
        {
            System.out.println(a);
        }
    }

    public static void main(String[] args)
    {
        q1 obj = new q1();

        obj.addMusic("Song A");
        obj.addMusic("Song B");
        obj.begining("Song Start");
        obj.last("Song End");
        obj.second();
        obj.printList();
    }
}
