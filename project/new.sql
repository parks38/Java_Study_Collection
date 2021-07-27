--  상위 카테고리 new 찾기 boolean 값 rootID 
select * 
from BOARD.dbo.BOARD b
where b.dc_id = $(rootId) AND
b.regdate >= DATEADD(MONTH, -2, GETDATE()); 

-- boolean 값으로 받고 
-- if true : List<String> newCategoryDate = {7400, 2300, 3333};
-- front 단에서 for(돌려서 ) $('a.category-' + newCategoryDate).addClass("new"); 

