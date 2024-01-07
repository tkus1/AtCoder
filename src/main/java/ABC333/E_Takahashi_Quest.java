package src.main.java.ABC333;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class E_Takahashi_Quest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Event[] events = new Event[N];
        for (int i = 0; i < N; i++) {
            events[i] = new Event(scanner.nextInt(), scanner.nextInt());
        }
        int firstPointer = 0;
        boolean canDefeatAllMonsters = true;
        for (int i = 0; i < N; i++) {
            if(events[i].getEventType() == 2){
                boolean canDefeat = false;
                int usedCategory = 0;
                for (int j = firstPointer; j < i; j++) {
                    Event targetEvent = events[j];
                    if(targetEvent.getCategory() == events[i].getCategory() && !canDefeat &&  targetEvent.getEventType()==1  && !targetEvent.isUsed() && targetEvent.canUse()){
                        targetEvent.setUsed(true);
                        targetEvent.prohibitToUse();
                        canDefeat = true;
                        usedCategory = targetEvent.getCategory();
                        if(firstPointer == j){
                            for (int k = j+1; k < i; k++) {
                                if(events[k].canUse){
                                    firstPointer = k;
                                    break;
                                }
                            }
                        }
                        continue;
                    }
                    if(targetEvent.getEventType() == 1 && !targetEvent.isUsed() && targetEvent.getCategory() == usedCategory){
                        targetEvent.prohibitToUse();
                        if(firstPointer == j){
                            firstPointer++;
                        }
                    }

                }
                if(!canDefeat){
                    canDefeatAllMonsters = false;
                    break;
                }
            }
        }
        int maxPotionCnt = 0;
        int potionCnt = 0;
        StringBuilder ansStringAction = new StringBuilder();
        StringBuilder ansString = new StringBuilder();
        if(canDefeatAllMonsters){
            for (int i = 0; i < N; i++) {
                if(events[i].getEventType() == 2){
                    potionCnt--;
                    continue;
                }
                if(events[i].isUsed()){
                    potionCnt++;
                    ansStringAction.append(" 1");
                    maxPotionCnt = Math.max(maxPotionCnt, potionCnt);
                }else{
                    ansStringAction.append(" 0");
                }
            }
            ansString.append(maxPotionCnt).append("\n");
            ansStringAction.delete(0,1);
            ansString.append(ansStringAction);

        }else{
            ansString.append(-1);
        }
        System.out.println(ansString);
    }
    public static class Event{
        private final int eventType;
        private final int category;
        private boolean used;
        private boolean canUse;
        public Event(int eventType, int category){
            this.eventType = eventType;
            this.category = category;
            this.used = false;
            this.canUse = true;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }
        public boolean isUsed(){
            return used;
        }
        public void prohibitToUse(){
            this.canUse = false;
        }
        public boolean canUse(){
            return canUse;
        }
        public int getCategory() {
            return category;
        }
        public int getEventType(){
            return eventType;
        }
    }
}
