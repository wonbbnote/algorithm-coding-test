class Solution {
    public String solution(String s) {
        
        return s.chars()                  // 문자열 s -> intStream으로 변환
            .boxed()                      // intStream -> Stream<Integer>
            .sorted((v1, v2) -> v2 - v1)  // 내림차순 정렬
            .collect(StringBuilder::new,  // collect()는 Stream의 모든 원소를 하나의 객체로 통합 (반환할 객체를 생성하는 함수 supplier, 반환할 객체에 Stre                                               am의 원소를 어떻게 누적할지 정의하는 함수 accumulator, 반환될 객체가 여러 개 있을 때 어떻게 합치는 정의하는 함수                                                (멀티스레드 환경에서 사용되어 코테 레벨x) combiner)
                    StringBuilder::appendCodePoint,
                    StringBuilder::append)
            .toString();

    }
}