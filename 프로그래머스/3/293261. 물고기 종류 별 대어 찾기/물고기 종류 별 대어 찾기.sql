SELECT ID, FISH_NAME, LENGTH
FROM FISH_INFO f JOIN FISH_NAME_INFO n ON f.FISH_TYPE = n.FISH_TYPE
WHERE (LENGTH, f.FISH_TYPE) IN (
                                SELECT MAX(LENGTH), FISH_TYPE
                                FROM FISH_INFO
                                GROUP BY FISH_TYPE
                            )
ORDER BY ID