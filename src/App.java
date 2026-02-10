public class App
{
    public static void main(String[] args)
    {
        int tab[] = new int[8];
        tab = mg.hr.Binary.toBinary(7, 3);
        for(int i = 0; i < tab.length; i++)
            System.out.print(tab[i]);
        System.out.println();
    }
}