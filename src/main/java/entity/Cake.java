package entity;

public class Cake {
    private Integer cakeId;

    private String cakeName;

    private String cakeCover;

    private String cakeImage1;

    private String cakeImage2;

    private String cakeIntro;

    private String cakeFlavor;

    private String material;

    private Integer sweet;

    private String temprature;

    private Double cakePrice;

    private Integer cakeStock;

    private Byte isHot;

    private Byte isNew;

    private Byte isRecommend;

    private Byte status;

    private Integer typeId;

private int cakeQty;
public int getCakeQty() {
	return cakeQty;
}
public void setCakeQty(int cakeQty) {
	this.cakeQty = cakeQty;
}

	public Integer getCakeId() {
		return cakeId;
	}

	public void setCakeId(Integer cakeId) {
		this.cakeId = cakeId;
	}

	public String getCakeName() {
		return cakeName;
	}

	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}

	public String getCakeCover() {
		return cakeCover;
	}

	public void setCakeCover(String cakeCover) {
		this.cakeCover = cakeCover;
	}

	public String getCakeImage1() {
		return cakeImage1;
	}

	public void setCakeImage1(String cakeImage1) {
		this.cakeImage1 = cakeImage1;
	}

	public String getCakeImage2() {
		return cakeImage2;
	}

	public void setCakeImage2(String cakeImage2) {
		this.cakeImage2 = cakeImage2;
	}

	public String getCakeIntro() {
		return cakeIntro;
	}

	public void setCakeIntro(String cakeIntro) {
		this.cakeIntro = cakeIntro;
	}

	public String getCakeFlavor() {
		return cakeFlavor;
	}

	public void setCakeFlavor(String cakeFlavor) {
		this.cakeFlavor = cakeFlavor;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Integer getSweet() {
		return sweet;
	}

	public void setSweet(Integer sweet) {
		this.sweet = sweet;
	}

	public String getTemprature() {
		return temprature;
	}

	public void setTemprature(String temprature) {
		this.temprature = temprature;
	}

	public Double getCakePrice() {
		return cakePrice;
	}

	public void setCakePrice(Double cakePrice) {
		this.cakePrice = cakePrice;
	}

	public Integer getCakeStock() {
		return cakeStock;
	}

	public void setCakeStock(Integer cakeStock) {
		this.cakeStock = cakeStock;
	}

	public Byte getIsHot() {
		return isHot;
	}

	public void setIsHot(Byte isHot) {
		this.isHot = isHot;
	}

	public Byte getIsNew() {
		return isNew;
	}

	public void setIsNew(Byte isNew) {
		this.isNew = isNew;
	}

	public Byte getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Byte isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	@Override
	public String toString() {
		return "Cake [cakeId=" + cakeId + ", cakeName=" + cakeName + ", cakeCover=" + cakeCover + ", cakeImage1="
				+ cakeImage1 + ", cakeImage2=" + cakeImage2 + ", cakeIntro=" + cakeIntro + ", cakeFlavor=" + cakeFlavor
				+ ", material=" + material + ", sweet=" + sweet + ", temprature=" + temprature + ", cakePrice="
				+ cakePrice + ", cakeStock=" + cakeStock + ", isHot=" + isHot + ", isNew=" + isNew + ", isRecommend="
				+ isRecommend + ", status=" + status + ", typeId=" + typeId + ", cakeQty=" + cakeQty + "]";
	}


    
	
}