package fxsmirnoff;
/**
 * @author Bhupesh Bhatia & Manprit Dhanoa
 */
public class TableRecord
{
    private String productId;
    private String productType;
    private String flavour;
    private String size;
    private String place;
    private String year;
    private String price;
    private String quantity;

    public TableRecord (String productId, String productType, String flavour, String size, String place, String year, String price, String quantity)
    {
        this.productId = productId;
        this.productType = productType;
        this.flavour = flavour;
        this.size = size;
        this.place = place;
        this.year = year;
        this.price = price;
        this.quantity = quantity;
    }


    public String getProductId ()
    {
        return productId;
    }

    public String getProductType ()
    {
        return productType;
    }

    public String getFlavour ()
    {
        return flavour;
    }

    public String getSize ()
    {
        return size;
    }

    public String getPlace ()
    {
        return place;
    }

    public String getYear ()
    {
        return year;
    }

    public String getPrice ()
    {
        return price;
    }

    public String getQuantity ()
    {
        return quantity;
    }


}
