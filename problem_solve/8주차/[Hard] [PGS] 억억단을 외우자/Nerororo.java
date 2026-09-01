class Solution {
    public int[] solution(int e, int[] starts) {
        // 몇번 등장했는지 체크
        int[] count = new int[e + 1];
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                count[j]++;
            }
        }

        /*
        구간 별 가장 많이 등장하는 숫자 저장
        끝값(e)가 고정이다. 때문에 매번 바뀌는
        starts[i] ~~~ e 까지의 범위 중 최빈수값을 구하면 된다.
        */
        int max = 0;
        // 빈도수 저장 배열
        int[] maxFrequency = new int[e + 1];
        for (int i = e; i > 0; i--) {
            if (count[i] >= count[max]) {
                max = i;
            }
            maxFrequency[i] = max;
        }

        // 답안 작성
        int[] answer = new int[starts.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = maxFrequency[starts[i]];
        }

        return answer;
    }
}

/*
세그먼트 트리의 경우 트리 생성에 O(n),
탐색과 갱신에 O(log n)의 시간 복잡도가 소요된다.
또한 트리 생성에 4n의 공간 복잡도가 필요하다.
다만, 이 문제의 경우 끝값이 고정이고 갱신이 일어나지 않음으로
좀 더 간단한 구현으로 해결 가능하다.

공간 복잡도 2n, 시간 복잡도 O(n)
*/