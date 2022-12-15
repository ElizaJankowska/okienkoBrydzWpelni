import java.util.ArrayList;

import java.util.Random;

public class RandomSequence {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<String> arrayList = new ArrayList<>();
        //dodawanie do listy słabych kart 2-9
        for (int i = 1; i < 9; i++) {
            arrayList.add(Integer.toString(i + 1));
        }
        //dodawanie do listy mocnych kart
        arrayList.add("T");
        arrayList.add("J");
        arrayList.add("Q");
        arrayList.add("K");
        arrayList.add("A");
        //paczymy czy wszystkie karty są
        System.out.println(arrayList);
        String card;
        //wylosowanie karty jeszcze trzeba je poukładać w kolorach
        String[] cards = new String[13];
        for (int i = 0; i < 13; i++) {
            int los = random.nextInt(12);
            card = arrayList.get(los);
            System.out.print(card + " ");
            cards[i] = card;
        }

        //zabawa kolorami
        String[] spades;
        String[] clubes;
        String[] heart;
        String[] diamond;
        int[] powtarzanie = new int[13];
        for (int i = 0; i < 13; i++) {
            powtarzanie[i] = 0;
        }
        //int dwojki = 0, trojki = 0, czworki = 0, piatki = 0, szostki = 0, siodemki = 0, osemki = 0, dziewiatki = 0, dziesiatki = 0, jopki = 0, damy = 0, krole = 0, asy = 0;

        //liczymy powtórkki??
        //w powtarzaniu asy są na pierwszym miejscu
        for (int i = 0; i < 13; i++) {
            if (cards[i].equals("2")) {
                powtarzanie[1] += 1;
            }
            if (cards[i].equals("3")) {
                powtarzanie[2] += 1;
            }
            if (cards[i].equals("4")) {
                powtarzanie[3] += 1;
            }
            if (cards[i].equals("5")) {
                powtarzanie[4] += 1;
            }
            if (cards[i].equals("6")) {
                powtarzanie[5] += 1;
            }
            if (cards[i].equals("7")) {
                powtarzanie[6] += 1;
            }
            if (cards[i].equals("8")) {
                powtarzanie[7] += 1;
            }
            if (cards[i].equals("9")) {
                powtarzanie[8] += 1;
            }
            if (cards[i].equals("T")) {
                powtarzanie[9] += 1;
            }
            if (cards[i].equals("J")) {
                powtarzanie[10] += 1;
            }
            if (cards[i].equals("Q")) {
                powtarzanie[11] += 1;
            }
            if (cards[i].equals("K")) {
                powtarzanie[12] += 1;
            }
            if (cards[i].equals("A")) {
                powtarzanie[0] += 1;
            }
        }
        System.out.print("\n");
        for (int i = 0; i < 13; i++) {
            System.out.print(powtarzanie[i]+" ");
        }

    }
}
