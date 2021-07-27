public class Category {
    private int id;
    private int parentId;
    private int rootId;
    private String categoryName;
    private List<CategoryVO> totalSubCategoryList; 
    private int countTotal;
    private List<String> navigationPath;

    private void setCountTotal(int countTotal) {
        this.countTotal = totalSubCategoryList.count;
    }



    /**
        예열 : 본인 count 

     */




    public class CategoryVO {
        private List<String> navigationPath;
        private int id;
        private int parentId; 
        private int rootId;
        private int categoryDepth;
        private int count; // 본인 값 

        private void setNavigationPath(List<String> navigationPath) {
            for(int i = 0; i <= categoryDepth; i++) {
                String[] depth = {"id", "parent", "root"};
                navigationPath.add(depth[i]);
            }
        }
    }

        

        

        /**
            navigationPath : TMT > 자동차 > 예열 
            
            depth = 2 
            예열 - null , count

            depth = 1
            자동차 -  예열 , count 

            depth = 0
         */
    }
}