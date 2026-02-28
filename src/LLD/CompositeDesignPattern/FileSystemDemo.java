package LLD.CompositeDesignPattern;

public class FileSystemDemo {
    public static void main(String[] args) {
        System.out.println("======= Composite Design Pattern ======");

        File receipt = new File("Recipt.txt");
        File invoice = new File("Invoice.txt");
        File torrentLinks = new File("TorrentLinks.txt");
        File musicLinks = new File("MusicLinks.txt");
        File movieLinks = new File("MobileLinks.txt");
        File tomCruies = new File("TomCruise.txt");
        File dumbAndDumber = new File("DumbAndDumber.txt");
        File hangOver = new File("HangOver.txt");

        File maheshBabu = new File("MaheshBabu.txt");
        File prabhas = new File("Prabhas.txt");
        File ntr = new File("NTR.txt");

        Directory moviesDirectory = new Directory("Movies");
        Directory documentsDirectory = new Directory("Documents");
        Directory linksDirectory = new Directory("links");
        Directory meenaNamesDirectory = new Directory("MeenaNames");
        moviesDirectory.add(tomCruies);
        moviesDirectory.add(dumbAndDumber);
        moviesDirectory.add(hangOver);

        documentsDirectory.add(receipt);
        documentsDirectory.add(invoice);

        linksDirectory.add(torrentLinks);
        linksDirectory.add(musicLinks);
        linksDirectory.add(movieLinks);

        meenaNamesDirectory.add(maheshBabu);
        meenaNamesDirectory.add(prabhas);
        meenaNamesDirectory.add(ntr);


        moviesDirectory.add(documentsDirectory);
        documentsDirectory.add(linksDirectory);
        moviesDirectory.add(meenaNamesDirectory);
       moviesDirectory.ls();

    }
}
