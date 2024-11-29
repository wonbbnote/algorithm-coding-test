-- 코드를 입력하세요
SELECT MEMBER_NAME, REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, "%Y-%m-%d") AS REVIEW_DATE
FROM REST_REVIEW a JOIN MEMBER_PROFILE b ON a.MEMBER_ID = b.MEMBER_ID
WHERE a.MEMBER_ID = (
                        SELECT m.MEMBER_ID
                        FROM REST_REVIEW r 
                        JOIN MEMBER_PROFILE m ON r.MEMBER_ID = m.MEMBER_ID
                        GROUP BY m.MEMBER_ID
                        ORDER BY COUNT(*) DESC
                        LIMIT 1
                    ) 
ORDER BY REVIEW_DATE, REVIEW_TEXT
;
