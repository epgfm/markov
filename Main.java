class Main {
    












    public static void main(String[] args) {
        System.out.println("Markov demo");

        Node n = new Node("lol");
        Node n2 = new Node("what");
        Node n3 = new Node("hihi");
        Node n4 = new Node("hihi");

        n.addNeighbor(n2);
        n.addNeighbor(n3);
        n.addNeighbor(n4);
        System.out.println(n);
        
        MarkovChain mc = new MarkovChain();
        System.out.println(mc);

        mc.addSentence("J'aime les chiens");
        mc.addSentence("J'aime les chats");
        mc.addSentence("J'aime les humains");
        mc.addSentence("J'aime les humains qui aiment les chats");
        System.out.println(mc);
        System.out.println(mc.generateSentence());
    }

}