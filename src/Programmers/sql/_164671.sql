-- 조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기
SELECT
    CONCAT('/home/grep/src/', gb.BOARD_ID, '/', gf.FILE_ID,
        gf.FILE_NAME, gf.FILE_EXT) AS FILE_PATH
FROM
    USED_GOODS_BOARD gb
JOIN
    USED_GOODS_FILE gf
ON
    gb.BOARD_ID = gf.BOARD_ID
WHERE
    gb.views = (select max(views) from USED_GOODS_BOARD limit 1)
ORDER BY
    gf.FILE_ID DESC
