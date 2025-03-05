# \[level 1] 자동차 대여 기록에서 장기/단기 대여 구분하기 - 151138

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/151138)

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > String， Date

### 채점결과

Empty

### 제출 일자

2024년 11월 29일 22:04:03

### 문제 설명

다음은 어느 자동차 대여 회사의 자동차 대여 기록 정보를 담은 `CAR_RENTAL_COMPANY_RENTAL_HISTORY` 테이블입니다. `CAR_RENTAL_COMPANY_RENTAL_HISTORY` 테이블은 아래와 같은 구조로 되어있으며, `HISTORY_ID`, `CAR_ID`, `START_DATE`, `END_DATE` 는 각각 자동차 대여 기록 ID, 자동차 ID, 대여 시작일, 대여 종료일을 나타냅니다.

| Column name | Type    | Nullable |
| ----------- | ------- | -------- |
| HISTORY\_ID | INTEGER | FALSE    |
| CAR\_ID     | INTEGER | FALSE    |
| START\_DATE | DATE    | FALSE    |
| END\_DATE   | DATE    | FALSE    |

***

**문제**

`CAR_RENTAL_COMPANY_RENTAL_HISTORY` 테이블에서 대여 시작일이 2022년 9월에 속하는 대여 기록에 대해서 대여 기간이 30일 이상이면 '장기 대여' 그렇지 않으면 '단기 대여' 로 표시하는 컬럼(컬럼명: `RENT_TYPE`)을 추가하여 대여기록을 출력하는 SQL문을 작성해주세요. 결과는 대여 기록 ID를 기준으로 내림차순 정렬해주세요.

***

**예시**

예를 들어 `CAR_RENTAL_COMPANY_RENTAL_HISTORY` 테이블이 다음과 같다면

| HISTORY\_ID | CAR\_ID | START\_DATE | END\_DATE  |
| ----------- | ------- | ----------- | ---------- |
| 1           | 4       | 2022-09-27  | 2022-11-27 |
| 2           | 3       | 2022-10-03  | 2022-11-04 |
| 3           | 2       | 2022-09-05  | 2022-09-05 |
| 4           | 1       | 2022-09-01  | 2022-09-30 |
| 5           | 3       | 2022-09-16  | 2022-10-15 |

2022년 9월의 대여 기록 중 '장기 대여' 에 해당하는 기록은 대여 기록 ID가 1, 4인 기록이고, '단기 대여' 에 해당하는 기록은 대여 기록 ID가 3, 5 인 기록이므로 대여 기록 ID를 기준으로 내림차순 정렬하면 다음과 같이 나와야 합니다.

| HISTORY\_ID | CAR\_ID | START\_DATE | END\_DATE  | RENT\_TYPE |
| ----------- | ------- | ----------- | ---------- | ---------- |
| 5           | 3       | 2022-09-16  | 2022-10-13 | 단기 대여      |
| 4           | 1       | 2022-09-01  | 2022-09-30 | 장기 대여      |
| 3           | 2       | 2022-09-05  | 2022-09-05 | 단기 대여      |
| 1           | 4       | 2022-09-27  | 2022-10-26 | 장기 대여      |

***

**주의사항**

`START_DATE`와 `END_DATE`의 경우 예시의 데이트 포맷과 동일해야 정답처리 됩니다.

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
