package readWrite;

public class QvvItem {
    private String key;
    private String itemCode;
    private String title;
    private String titleType;
    private String recordDate;
    private String startOfMaterial;
    private String keyPlayer;
    private String copyright;
    private String productionTitle;
    private String classification;
    private String description;
    private String salesEditorial;
    private String salesCreative;
    private String programIn;
    private String color;
    private String productCat;
    private String category;
    private String keywordEng;
    private String keywordDe;
    private String credits;
    private String productionId;
    private String producer;
    private String cameraType;
    private String keyFrame;
    private String progTcIn;
    private String progTcOut;
    private String clipTcIn;
    private String clipTcOut;
    private String transcript;
    private String duration;
    private String location;
    private String region;
    private String country;
    private String interviewId;
    private String bRollInt;


    public QvvItem(String key, String title, String recordDate, String startOfMaterial, String keyPlayer, String copyright,
                   String productionTitle, String classification, String description, String interviewId, String bRollInt, String salesEditorial,
                   String salesCreative, String programIn, String color, String productCat, String category, String keywordEng, String keywordDe,
                   String credits, String productionId, String producer, String cameraType, String progTcIn, String progTcOut, String location,
                   String region, String country, String keyFrame, String clipTcIn, String clipTcOut) {
        this.key = key;
        this.title = title;
        this.recordDate = recordDate;
        this.startOfMaterial = startOfMaterial;
        this.keyPlayer = keyPlayer;
        this.copyright = copyright;
        this.productionTitle = productionTitle;
        this.classification = classification;
        this.description = description;
        this.interviewId = interviewId;
        this.bRollInt = bRollInt;
        this.salesEditorial = salesEditorial;
        this.salesCreative = salesCreative;
        this.programIn = programIn;
        this.color = color;
        this.productCat = productCat;
        this.category = category;
        this.keywordEng = keywordEng;
        this.keywordDe = keywordDe;
        this.credits = credits;
        this.productionId = productionId;
        this.producer = producer;
        this.cameraType = cameraType;
        this.progTcIn = progTcIn;
        this.progTcOut = progTcOut;
        this.location = location;
        this.region = region;
        this.country = country;
        this.keyFrame = keyFrame;
        this.clipTcIn = clipTcIn;
        this.clipTcOut = clipTcOut;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getStartOfMaterial() {
        return startOfMaterial;
    }

    public void setStartOfMaterial(String startOfMaterial) {
        this.startOfMaterial = startOfMaterial;
    }

    public String getKeyPlayer() {
        return keyPlayer;
    }

    public void setKeyPlayer(String keyPlayer) {
        this.keyPlayer = keyPlayer;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getProductionTitle() {
        return productionTitle;
    }

    public void setProductionTitle(String productionTitle) {
        this.productionTitle = productionTitle;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSalesEditorial() {
        return salesEditorial;
    }

    public void setSalesEditorial(String salesEditorial) {
        this.salesEditorial = salesEditorial;
    }

    public String getSalesCreative() {
        return salesCreative;
    }

    public void setSalesCreative(String salesCreative) {
        this.salesCreative = salesCreative;
    }

    public String getProgramIn() {
        return programIn;
    }

    public void setProgramIn(String programIn) {
        this.programIn = programIn;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProductCat() {
        return productCat;
    }

    public void setProductCat(String productCat) {
        this.productCat = productCat;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getCameraType() {
        return cameraType;
    }

    public void setCameraType(String cameraType) {
        this.cameraType = cameraType;
    }

    public String getKeyFrame() {
        return keyFrame;
    }

    public void setKeyFrame(String keyFrame) {
        this.keyFrame = keyFrame;
    }

    public String getProgTcIn() {
        return progTcIn;
    }

    public void setProgTcIn(String progTcIn) {
        this.progTcIn = progTcIn;
    }

    public String getProgTcOut() {
        return progTcOut;
    }

    public void setProgTcOut(String progTcOut) {
        this.progTcOut = progTcOut;
    }

    public String getClipTcIn() {
        return clipTcIn;
    }

    public void setClipTcIn(String clipTcIn) {
        this.clipTcIn = clipTcIn;
    }

    public String getClipTcOut() {
        return clipTcOut;
    }

    public void setClipTcOut(String clipTcOut) {
        this.clipTcOut = clipTcOut;
    }

    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(String interviewId) {
        this.interviewId = interviewId;
    }

    public String getbRollInt() {
        return bRollInt;
    }

    public void setbRollInt(String bRollInt) {
        this.bRollInt = bRollInt;
    }

    public String getKeywordEng() {
        return keywordEng;
    }

    public void setKeywordEng(String keywordEng) {
        this.keywordEng = keywordEng;
    }

    public String getKeywordDe() {
        return keywordDe;
    }

    public void setKeywordDe(String keywordDe) {
        this.keywordDe = keywordDe;
    }

    @Override
    public String toString() {
        return "QvvItem{" +
                "key='" + key + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", title='" + title + '\'' +
                ", titleType='" + titleType + '\'' +
                ", recordDate='" + recordDate + '\'' +
                ", startOfMaterial='" + startOfMaterial + '\'' +
                ", keyPlayer='" + keyPlayer + '\'' +
                ", copyright='" + copyright + '\'' +
                ", productionTitle='" + productionTitle + '\'' +
                ", classification='" + classification + '\'' +
                ", description='" + description + '\'' +
                ", salesEditorial='" + salesEditorial + '\'' +
                ", salesCreative='" + salesCreative + '\'' +
                ", programIn='" + programIn + '\'' +
                ", color='" + color + '\'' +
                ", productCat='" + productCat + '\'' +
                ", category='" + category + '\'' +
                ", keyword='" + keywordEng + '\'' +
                ", keyword='" + keywordDe + '\'' +
                ", credits='" + credits + '\'' +
                ", productionId='" + productionId + '\'' +
                ", producer='" + producer + '\'' +
                ", cameraType='" + cameraType + '\'' +
                ", keyFrame='" + keyFrame + '\'' +
                ", progTcIn='" + progTcIn + '\'' +
                ", progTcOut='" + progTcOut + '\'' +
                ", clipTcIn='" + clipTcIn + '\'' +
                ", clipTcOut='" + clipTcOut + '\'' +
                ", transcript='" + transcript + '\'' +
                ", duration='" + duration + '\'' +
                ", location='" + location + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
