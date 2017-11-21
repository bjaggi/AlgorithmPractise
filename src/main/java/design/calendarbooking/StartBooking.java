package design.calendarbooking;


import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Scanner;
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


            Assert.assertTrue(HasConflict(list));
            Assert.assertFalse(HasConflict(list2));

        }

    //O(NlogN) for sorting, O(N) for checking
    static boolean  HasConflict(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return false;
        //intervals = intervals.OrderBy(x => x.Start).ToList();

        for (int i = 0; i < intervals.size() - 1; i++) {
            if (IsOverlap(intervals.get(i), intervals.get(i + 1))) {
                return true;
            }
        }
        return false;
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