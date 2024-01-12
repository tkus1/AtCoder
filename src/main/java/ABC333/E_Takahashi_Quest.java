package src.main.java.ABC333;

import java.util.*;

public class E_Takahashi_Quest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Event[] events = new Event[N];
        for (int i = 0; i < N; i++) {
            events[i] = new Event(scanner.nextInt(), scanner.nextInt());
        }
        ArrayList<Event>[] potionList = new ArrayList[N];
        boolean canDefeat = true;
        for (int i = 0; i < N; i++) {
            //Monsterが現れた場合
            if(events[i].getEventType() == 2){
                //倒せなかった場合
                if(potionList[events[i].getCategory()] == null || potionList[events[i].getCategory()].isEmpty()){
                    canDefeat = false;
                    break;
                }
                //倒せる場合
                potionList[events[i].getCategory()].remove(potionList[events[i].getCategory()].size()-1).setUsed(true);
                continue;
            }
            //Potionが現れた場合
            if(potionList[events[i].getCategory()] == null){
                potionList[events[i].getCategory()] = new ArrayList<>();
            }
            potionList[events[i].getCategory()].add(events[i]);
        }
        StringBuilder action = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int potionCnt = 0;
        int maxPotionCnt = 0;
        if(canDefeat){
            for (int i = 0; i < N; i++) {
                if (events[i].getEventType() == 2){
                    potionCnt--;
                    continue;
                }
                if(events[i].isUsed()){
                    action.append(" 1");
                    potionCnt++;
                    maxPotionCnt = Math.max(maxPotionCnt, potionCnt);
                    continue;
                }
                action.append(" 0");
            }
            action.delete(0,1);
            answer.append(maxPotionCnt).append("\n").append(action);
        }else {
            answer.append(-1);
        }
        System.out.println(answer);
    }
    public static class Event{
        private final int eventType;
        private final int category;
        private boolean used;
            public Event(int eventType, int category){
            this.eventType = eventType;
            this.category = category;
            this.used = false;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }
        public boolean isUsed(){
            return used;
        }
        public int getCategory() {
            return category;
        }
        public int getEventType(){
            return eventType;
        }
    }
}
