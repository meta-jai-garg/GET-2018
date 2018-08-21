
public class CategoryPojo {
	private String topCategory;
	private int childCategoryCount;
	public String getTopCategory() {
		return topCategory;
	}
	public int getChildCategoryCount() {
		return childCategoryCount;
	}
	public void setTopCategory(String topCategory) {
		this.topCategory = topCategory;
	}
	public void setChildCategoryCount(int childCategoryCount) {
		this.childCategoryCount = childCategoryCount;
	}
	@Override
	public String toString() {
		return "CategoryPojo [topCategory=" + topCategory
				+ ", childCategoryCount=" + childCategoryCount + "]";
	}
	
	
}
