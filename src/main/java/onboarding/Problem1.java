package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (isException(pobi) || isException(crong)) {
            return -1;
        }

        int differ = getScore(pobi) - getScore(crong);

        if (differ > 0) {
            answer = 1;
        } else if (differ < 0) {
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }

    public static boolean isException(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if ((rightPage - leftPage) != 1) {
            return true;
        }

        if (leftPage % 2 != 1) {
            return true;
        }

        if (leftPage < 1 || rightPage > 400) {
            return true;
        }

        return false;
    }

    public static List<Integer> splitNum(int num) {
        int myNum = num;
        List<Integer> result = new ArrayList<>();
        while (myNum > 0) {
            result.add(myNum % 10);
            myNum /= 10;
        }

        return result;
    }

    public static int getScore(List<Integer> pages) {
        int score = -1;
        for (int page : pages) {
            List<Integer> splitedNum = splitNum(page);
            int addScore = getAddScore(splitedNum);
            int mulScore = getMulScore(splitedNum);

            int temp = (addScore > mulScore) ? addScore : mulScore;

            score = (temp > score) ? temp : score;
        }

        return score;
    }

    public static int getAddScore(List<Integer> splitedNum) {
        int addScore = 0;

        for(int num: splitedNum) {
            addScore += num;
        }

        return addScore;
    }

    public static int getMulScore(List<Integer> splitedNum) {
        int mulScore = 1;

        for(int num: splitedNum) {
            mulScore *= num;
        }

        return mulScore;
    }
}