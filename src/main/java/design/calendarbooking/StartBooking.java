package design.calendarbooking;


import org.junit.Assert;

import java.util.*;
//https://www.youtube.com/watch?v=olK6SWl8UrM&t=1s

public class StartBooking {


        public static void main(String[] args) {
            List<Interval> list = new ArrayList<Interval>(
                Arrays.asList(
                new Interval(1, 3),
                        new Interval(9, 16),
                        new Interval(2, 5)));


            List<Interval> list2 = new ArrayList<Interval>(
                    Arrays.asList(new Interval(1, 3),
                        new Interval(5, 10),
                        new Interval(20, 50)));




            System.out.println("List="+list+" , has conflicts="+canAttendMeetings(list));
            System.out.println("List2="+list2+" , has conflicts="+canAttendMeetings(list2));


        }

    //O(NlogN) for sorting, O(N) for checking

    /**
     * 1. SORT BY START TIME
     * 2. MAKE SURE END_TIME IS NEVER GREATER THAN NEXT START TIME.
     * @param intervals
     * @return
     */
    static public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start-b.start;
            }
        });
        for(int i=0; i<intervals.size()-1; i++){
            if(intervals.get(i).end>intervals.get(i+1).start){ // END_TIME IS NEVER GREATER THAN NEXT START TIME.
                return false;
            }
        }
        return true;
    }


    static boolean IsOverlap(Interval i1, Interval i2) {
        if (i1.start < i2.start) {
            return i1.end > i2.start;
        }
        if (i1.start > i2.start) {
            return i1.end < i2.end;
        }
        return false;
    }

}

class Interval{
    int start;
    int end;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Interval{");
        sb.append("start=").append(start);
        sb.append(", end=").append(end);
        sb.append('}');
        return sb.toString();
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}