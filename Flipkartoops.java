package Flipkart;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//----------Cart Item--------
class CartItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

// ----------Order class-----------
class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private int orderId;
    private String customerName;
    private String productName;
    private double price;
    private int quantity;
    private double totalAmount;
    private LocalDateTime orderDate;
    private String status;

    Order(int orderId, String customerName, String productName,
            double price, LocalDateTime orderDate, int quantity, String status) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.totalAmount = price * quantity;
        this.orderDate = orderDate;
        this.status = status;
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    // Setter
    public void setStatus(String status) {
        this.status = status;
    }

    // Display
    public void display() {
        System.out.println("----------------------------------");
        System.out.println("Order ID      : " + orderId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Product Name  : " + productName);
        System.out.println("Price         : Rs." + price);
        System.out.println("Quantity      : " + quantity);
        System.out.println("Total Amount  : Rs." + totalAmount);
        System.out.println("Order Date    : " + orderDate);
        System.out.println("Status        : " + status);
        System.out.println("----------------------------------");
    }
}

// ---------------- PRODUCT CLASS ----------------
class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    protected int id;
    protected String name;
    protected String category;
    protected double price;
    protected int stock;

    Product(int id, String name, String category, double price, int stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    // Getter Methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // Setter Methods
    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Display Method
    public void display() {
        System.out.println("ID       : " + id);
        System.out.println("Name     : " + name);
        System.out.println("Category : " + category);
        System.out.println("Price    : Rs." + price);
        System.out.println("Stock    : " + stock);
    }

    @Override
    public String toString() {
        return id + "," + name + "," + category + "," + price + "," + stock;
    }
}

class FetureFashion extends Product {
    private static final long serialVersionUID = 1L;
    protected String size;
    protected String colour;
    protected String brand;
    protected String Febric;
    protected String suitable;
    protected String necktype;

    FetureFashion(int id, String name, String category, double price, int stock, String size, String colour,
            String brand, String Febric, String suitable, String necktype) {
        super(id, name, category, price, stock);
        this.size = size;
        this.colour = colour;
        this.brand = brand;
        this.Febric = Febric;
        this.suitable = suitable;
        this.necktype = necktype;
    }

    // Getter Methods
    public String getSize() {
        return size;
    }

    public String getColour() {
        return colour;
    }

    public String getBrand() {
        return brand;
    }

    public String getFebric() {
        return Febric;
    }

    public String getSuitable() {
        return suitable;
    }

    public String getNecktype() {
        return necktype;
    }

    // Setter methods
    public void setSize(String size) {
        this.size = size;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setFebric(String Febric) {
        this.Febric = Febric;
    }

    public void setSuitable(String suitable) {
        this.suitable = suitable;
    }

    public void setNecktype(String necktype) {
        this.necktype = necktype;
    }

    public void displayFeature() {
        super.display();
        System.out.println("Size      : " + size);
        System.out.println("Colour    : " + colour);
        System.out.println("Brand     : " + brand);
        System.out.println("Fabric    : " + Febric);
        System.out.println("Suitable  : " + suitable);
        System.out.println("Neck Type : " + necktype);
    }

    @Override
    public String toString() {
        return id + "," + name + "," + category + "," + price + "," + stock + "," + size + "," + colour + "," + brand
                + "," + Febric + "," + suitable + "," + necktype;
    }
}

class FetureElectronic extends Product {
    private static final long serialVersionUID = 1L;
    protected String Bluethooth;
    protected int Batterylife;
    protected String Colour;
    protected String Ic;

    FetureElectronic(int id, String name, String category, double price, int stock, String Bluethooth, int Batterylife,
            String Colour, String Ic) {
        super(id, name, category, price, stock);
        this.Bluethooth = Bluethooth;
        this.Batterylife = Batterylife;
        this.Colour = Colour;
        this.Ic = Ic;
    }

    public void setBluethooth(String Bluethooth) {
        this.Bluethooth = Bluethooth;
    }

    public void setBatterylife(int Batterylife) {
        this.Batterylife = Batterylife;
    }

    public void setColour(String Colour) {
        this.Colour = Colour;
    }

    public void setIc(String Ic) {
        this.Ic = Ic;
    }

    public void displayFeature() {
        super.display();
        System.out.println("Bluetooth    : " + Bluethooth);
        System.out.println("Battery Life : " + Batterylife + " Hr");
        System.out.println("Colour       : " + Colour);
        System.out.println("IC           : " + Ic);
    }

    @Override
    public String toString() {
        return id + "," + name + "," + category + "," + price + "," + stock + "," + Bluethooth + "," + Batterylife + ","
                + Colour + "," + Ic;
    }
}

class FetureGadjet extends Product {
    private static final long serialVersionUID = 1L;
    protected String Series;
    protected int Ram;
    protected int Rom;
    protected int Camera;
    protected String processer;
    protected String Display;

    FetureGadjet(int id, String name, String category, double price, int stock, String Series, int Ram, int Rom,
            int Camera, String processer, String Display) {
        super(id, name, category, price, stock);
        this.Series = Series;
        this.Ram = Ram;
        this.Rom = Rom;
        this.Camera = Camera;
        this.processer = processer;
        this.Display = Display;
    }

    public void setSeries(String Series) {
        this.Series = Series;
    }

    public void setRam(int Ram) {
        this.Ram = Ram;
    }

    public void setRom(int Rom) {
        this.Rom = Rom;
    }

    public void setCamera(int Camera) {
        this.Camera = Camera;
    }

    public void setProcesser(String processer) {
        this.processer = processer;
    }

    public void setDisplay(String Display) {
        this.Display = Display;
    }

    public void displayFeature() {
        super.display();
        System.out.println("Series    : " + Series);
        System.out.println("RAM       : " + Ram + " GB");
        System.out.println("ROM       : " + Rom + " GB");
        System.out.println("Camera    : " + Camera + " MP");
        System.out.println("Processor : " + processer);
        System.out.println("Display   : " + Display);
    }

    @Override
    public String toString() {
        return id + "," + name + "," + category + "," + price + "," + stock + "," + Series + "," + Ram + "," + Rom + ","
                + Camera + "," + processer + "," + Display;
    }
}

// ---------------- USER CLASS ----------------
class User implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String username;
    protected String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return username + "," + password;
    }
}

// ---------------- ADMIN CLASS ----------------
class Admin extends User {
    private static final long serialVersionUID = 1L;

    Admin(String username, String password) {
        super(username, password);
    }

    // Add Product
    public void addProduct(ArrayList<Product> products, Scanner sc) {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        for (Product p : products) {
            if (p.getId() == id) {
                System.out.println("ID already exists");
                return;
            }
        }
        sc.nextLine();
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Product Price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Stock of product: ");
        int stock = sc.nextInt();
        sc.nextLine();

        System.out.println("Select Category:");
        System.out.println("1. Gadget");
        System.out.println("2. Electronics");
        System.out.println("3. Fashion");
        System.out.println("4. Other");

        System.out.print("Enter Choice: ");
        int ch = sc.nextInt();
        sc.nextLine(); // Fix for Scanner buffer issue

        String category;

        switch (ch) {
            case 1:
                category = "Gadget";
                System.out.print("Enter Product Series: ");
                String Series = sc.nextLine();
                System.out.print("Enter Product RAM: ");
                int Ram = sc.nextInt();
                System.out.print("Enter Product ROM: ");
                int Rom = sc.nextInt();
                System.out.print("Enter Product Camera: ");
                int Camera = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Product Processor: ");
                String processer = sc.nextLine();
                System.out.print("Enter Product Display: ");
                String Display = sc.nextLine();

                FetureGadjet g = new FetureGadjet(id, name, category, price, stock, Series, Ram, Rom, Camera, processer,
                        Display);
                products.add(g);
                break;

            case 2:
                category = "Electronics";
                System.out.print("Enter Bluetooth Support: ");
                String Bluethooth = sc.nextLine();
                System.out.print("Enter Battery Life: ");
                int Batterylife = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Product Colour: ");
                String Colour = sc.nextLine();
                System.out.print("Enter IC: ");
                String Ic = sc.nextLine();

                FetureElectronic e = new FetureElectronic(id, name, category, price, stock, Bluethooth, Batterylife,
                        Colour, Ic);
                products.add(e);
                break;

            case 3:
                category = "Fashion";
                System.out.print("Enter Size: ");
                String size = sc.nextLine();
                System.out.print("Enter Colour: ");
                String colour = sc.nextLine();
                System.out.print("Enter Brand: ");
                String brand = sc.nextLine();
                System.out.print("Enter Fabric: ");
                String Febric = sc.nextLine();
                System.out.print("Enter Suitable for: ");
                String suitable = sc.nextLine();
                System.out.print("Enter Neck Style: ");
                String neckstyle = sc.nextLine();

                FetureFashion f = new FetureFashion(id, name, category, price, stock, size, colour, brand, Febric,
                        suitable, neckstyle);
                products.add(f);
                break;

            default:
                category = "Other";
                Product p = new Product(id, name, category, price, stock);
                products.add(p);
                break;
        }
        System.out.println("Product Added Successfully!");
    }

    public void viewProducts(ArrayList<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No Products Available!");
            return;
        }
        System.out.println("\n----- PRODUCT LIST -----");
        for (Product p : products) {
            p.display();
            System.out.println("------------------------");
        }
    }

    public void updateProduct(ArrayList<Product> products, Scanner sc) {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        boolean flag = true;
        for (Product p : products) {
            if (p.getId() == id) {
                flag = false;
                sc.nextLine();
                System.out.print("Enter New Name: ");
                String name = sc.nextLine();
                System.out.print("Enter New Price: ");
                double price = sc.nextDouble();
                p.setName(name);
                p.setPrice(price);

                System.out.println("Do you Want changes to its features as well ?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int ch = sc.nextInt();
                sc.nextLine(); // Clear buffer

                if (ch == 1) {
                    if (p instanceof FetureElectronic) {
                        FetureElectronic e = (FetureElectronic) p;
                        System.out.print("Enter Bluetooth Support: ");
                        e.setBluethooth(sc.nextLine());
                        System.out.print("Enter New Battery Life: ");
                        e.setBatterylife(sc.nextInt());
                        sc.nextLine();
                        System.out.print("Enter New Product Colour: ");
                        e.setColour(sc.nextLine());
                        System.out.print("Enter IC: ");
                        e.setIc(sc.nextLine());
                    } else if (p instanceof FetureGadjet) {
                        FetureGadjet g = (FetureGadjet) p;
                        System.out.print("Enter Series Support: ");
                        g.setSeries(sc.nextLine());
                        System.out.print("Enter New Ram: ");
                        g.setRam(sc.nextInt());
                        System.out.print("Enter New Rom: ");
                        g.setRom(sc.nextInt());
                        System.out.print("Enter New Camera: ");
                        g.setCamera(sc.nextInt());
                        sc.nextLine();
                        System.out.print("Enter New Processor: ");
                        g.setProcesser(sc.nextLine());
                        System.out.print("Enter Display: ");
                        g.setDisplay(sc.nextLine());
                    } else if (p instanceof FetureFashion) {
                        FetureFashion f = (FetureFashion) p;
                        System.out.print("Enter Size: ");
                        f.setSize(sc.nextLine());
                        System.out.print("Enter Colour: ");
                        f.setColour(sc.nextLine());
                        System.out.print("Enter Brand: ");
                        f.setBrand(sc.nextLine());
                        System.out.print("Enter Fabric: ");
                        f.setFebric(sc.nextLine());
                        System.out.print("Enter Suitable for: ");
                        f.setSuitable(sc.nextLine());
                        System.out.print("Enter Neck Type: ");
                        f.setNecktype(sc.nextLine());
                    }
                }
                System.out.println("Product Updated!");
                break;
            }
        }
        if (flag) {
            System.out.println("Product Not Found!");
        }
    }

    public void removeProduct(ArrayList<Product> products, Scanner sc) {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getId() == id) {
                iterator.remove();
                System.out.println("Product Removed!");
                return;
            }
        }
        System.out.println("Product Not Found!");
    }

    public void salesReport(ArrayList<Order> orders) {
        if (orders.isEmpty()) {
            System.out.println("\nNo Sales Available!");
            return;
        }
        double totalRevenue = 0;
        System.out.println("\n========== SALES REPORT ==========\n");
        for (Order order : orders) {
            order.display();
            totalRevenue += order.getTotalAmount();
        }
        System.out.println("---------------------------------------");
        System.out.println("Total Orders  : " + orders.size());
        System.out.println("Total Revenue : Rs." + totalRevenue);
        System.out.println("Average Sale  : Rs." + (totalRevenue / orders.size()));
        System.out.println("=======================================");
    }

    public void updateStock(ArrayList<Product> products, Scanner sc) {
        System.out.print("Enter Product ID : ");
        int id = sc.nextInt();
        boolean found = false;

        for (Product p : products) {
            if (p.getId() == id) {
                found = true;
                System.out.println("Current Stock : " + p.getStock());
                System.out.print("Enter New Stock : ");
                int stock = sc.nextInt();
                p.setStock(stock);
                System.out.println("Stock Updated Successfully...");
                break;
            }
        }
        if (!found) {
            System.out.println("Product Not Found.");
        }
    }

    public void addStock(ArrayList<Product> products, Scanner sc) {
        System.out.print("Enter Product ID : ");
        int id = sc.nextInt();
        boolean found = false;

        for (Product p : products) {
            if (p.getId() == id) {
                found = true;
                System.out.print("Enter Quantity : ");
                int qty = sc.nextInt();
                p.setStock(p.getStock() + qty);
                System.out.println("Stock Added Successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Product Not Found.");
        }
    }

    public void lowStockAlert(ArrayList<Product> products) {
        System.out.println("\n===== LOW STOCK PRODUCTS =====");
        boolean found = false;
        for (Product p : products) {
            if (p.getStock() <= 5) {
                p.display();
                System.out.println("-------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Low Stock Product.");
        }
    }

    public void outOfStock(ArrayList<Product> products) {
        System.out.println("\n===== OUT OF STOCK =====");
        boolean found = false;
        for (Product p : products) {
            if (p.getStock() == 0) {
                p.display();
                System.out.println("----------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Product Out Of Stock.");
        }
    }

    public void updateOrderStatus(ArrayList<Order> orders, Scanner sc) {
        System.out.print("Enter Order ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Order o : orders) {
            if (o.getOrderId() == id) {
                System.out.println("1. Packed");
                System.out.println("2. Shipped");
                System.out.println("3. Out For Delivery");
                System.out.println("4. Delivered");
                System.out.print("Choose Status : ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        o.setStatus("Packed");
                        break;
                    case 2:
                        o.setStatus("Shipped");
                        break;
                    case 3:
                        o.setStatus("Out For Delivery");
                        break;
                    case 4:
                        o.setStatus("Delivered");
                        break;
                    default:
                        System.out.println("Invalid Choice.");
                        return;
                }
                System.out.println("Order Status Updated Successfully.");
                return;
            }
        }
        System.out.println("Order Not Found.");
    }

    public void newOrderNotification(ArrayList<Order> orders) {
        if (orders.isEmpty()) {
            System.out.println("\n==================================");
            System.out.println("No Orders Available.");
            System.out.println("==================================");
            return;
        }

        System.out.println("\n==================================");
        System.out.println("      NEW ORDER NOTIFICATION");
        System.out.println("==================================");

        int count = 0;
        for (Order o : orders) {
            if (o.getStatus().equalsIgnoreCase("Ordered")) {
                count++;
                System.out.println("-------------------------------");
                System.out.println("Order ID      : " + o.getOrderId());
                System.out.println("Customer Name : " + o.getCustomerName());
                System.out.println("Product Name  : " + o.getProductName());
                System.out.println("Quantity      : " + o.getQuantity());
                System.out.println("Amount        : Rs." + o.getTotalAmount());
                System.out.println("Order Time    : " + o.getOrderDate());
                System.out.println("Status        : " + o.getStatus());
            }
        }

        if (count == 0) {
            System.out.println("No New Orders Pending.");
        } else {
            System.out.println("----------------------------------");
            System.out.println("Total New Orders : " + count);
        }
        System.out.println("==================================");
    }
}

// ---------------- CUSTOMER CLASS ----------------
class Customer extends User implements Serializable {
    private static final long serialVersionUID = 1L;
    ArrayList<Product> cart = new ArrayList<>();
    private ArrayList<Product> buy = new ArrayList<>();
    private ArrayList<Product> History = new ArrayList<>();
    protected long mobile;
    protected long UPI_Number;
    protected int UPI_pin;
    protected String address;
    boolean applycode = false;

    Customer(String username, String password, long mobile, long UPI_Number, int UPI_pin, String address) {
        super(username, password);
        this.mobile = mobile;
        this.UPI_Number = UPI_Number;
        this.UPI_pin = UPI_pin;
        this.address = address;
    }

    public String getusername() {
        return username;
    }

    public long getMobileNumber() {
        return mobile;
    }

    public long getUPI_Number() {
        return UPI_Number;
    }

    public int getUPI_pin() {
        return UPI_pin;
    }

    @Override
    public String toString() {
        return username + "," + password + "," + mobile + "," + UPI_Number + "," + UPI_pin + "," + address;
    }

    public void viewProducts(ArrayList<Product> products) {
        if (products.isEmpty()) {
            System.out.println("\nNo Products Available!");
            return;
        }
        System.out
                .println("\n<<<<<<<<<<<<<----------------------- PRODUCT LIST -------------------------->>>>>>>>>>>>>");
        for (Product p : products) {
            p.display();
            System.out.println("------------------------------------------------------------------------------------");
        }
    }

    public void searchProduct(ArrayList<Product> products, Scanner sc) {
        sc.nextLine();
        System.out.print("Enter Product Name: ");
        String search = sc.nextLine();

        boolean found = false;
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(search)) {
                found = true;
                if (p instanceof FetureElectronic) {
                    ((FetureElectronic) p).displayFeature();
                } else if (p instanceof FetureGadjet) {
                    ((FetureGadjet) p).displayFeature();
                } else if (p instanceof FetureFashion) {
                    ((FetureFashion) p).displayFeature();
                } else {
                    p.display();
                }
            }
        }
        if (!found) {
            System.out.println("\nProduct Not Found!\n");
        }
    }

    public void addToCart(ArrayList<Product> products, Scanner sc) {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        for (Product p : products) {
            if (p.getId() == id) {
                if (p.getStock() > 0) {
                    cart.add(p);
                    System.out.println("Product Added Successfully.");
                } else {
                    System.out.println("Product Out Of Stock.");
                }
                return;
            }
        }
        System.out.println("Product Not Found!");
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is Empty!");
            return;
        }
        double total = 0;
        System.out.println("\n--------------- CART ------------------");
        for (Product p : cart) {
            p.display();
            total += p.getPrice();
        }
        System.out.println("<<<<<<<=============================>>>>>>>");
        System.out.println("Total Amount              = +Rs. " + total);
        double gst = total * 18 / 100.0;
        System.out.println("GST 18%                   = +Rs. " + gst);
        double dis = total * 0.1;
        System.out.println("Discount 10%              = -Rs. " + dis);
        double f = total + gst - dis;
        System.out.println("<<<<<<<=============================>>>>>>>");
        System.out.println("Finally Total Amount:     =  Rs. " + f);
    }

    public void viewHistory() {
        if (History.isEmpty()) {
            System.out.println("History is Empty!");
            return;
        }
        for (Product p : History) {
            p.display();
            System.out.println("Order Delivered.\n");
        }
    }

    public void billing() {
        System.out.println("<<<<<<<<<<============ Final Bill ============>>>>>>>>>>");
        double total = 0;
        for (Product p : buy) {
            History.add(p);
            p.display();
            total += p.getPrice();
        }
        System.out.println("*******=============_________________=============*******");
        System.out.println("Total Amount                      = +Rs. " + total);
        double gst = total * (18.0 / 100);
        System.out.println("GST 18%                           = +Rs. " + gst);
        double dis = total * 0.1;
        System.out.println("Discount 10%                      = -Rs. " + dis);
        double f = total + gst - dis;

        if (applycode) {
            double couponDis = f * 0.20;
            f = f - couponDis;
            System.out.println("Coupon discount 20%               = -Rs. " + couponDis);
        }
        System.out.println("<<<<<<<============================================>>>>>>>");
        System.out.println("Finally Total Amount:             =  Rs. " + f);
        System.out.println();
    }

    public void buyProduct(ArrayList<Customer> customers, ArrayList<Order> orders, Scanner sc) {
        if (cart.isEmpty()) {
            System.out.println("Cart is Empty!");
            return;
        }

        buy = new ArrayList<>(cart);
        double total = 0;
        for (Product p : buy) {
            if (p.getStock() > 0) {
                p.setStock(p.getStock() - 1);
                total += p.getPrice();
                System.out.println("You can order: " + p.getName());
            } else {
                System.out.println(p.getName() + " is Out Of Stock");
            }
        }

        System.out.println("20% off Coupon code := @PHKEF");
        System.out.println("1. Apply Coupon code");
        System.out.println("2. Not any code");
        System.out.print("Enter Choice: ");
        int cd = sc.nextInt();

        switch (cd) {
            case 1:
                System.out.print("Enter Coupon code: ");
                sc.nextLine();
                String code = sc.nextLine();
                if ("@PHKEF".equals(code)) {
                    applycode = true;
                    System.out.println("Congratulations! 20% off Applied.");
                } else {
                    applycode = false;
                    System.out.println("Code Not Matched..");
                }
                break;
            case 2:
                applycode = false;
                break;
            default:
                applycode = false;
                System.out.println("Invalid choice.");
        }

        System.out.println("\n!!!!.... Payment Method....!!!!");
        System.out.println("1. UPI System");
        System.out.println("2. Cash on Delivery");
        System.out.println("3. Back");
        System.out.print("Choose Any one Method: ");
        int ch = sc.nextInt();

        Random random = new Random();
        switch (ch) {
            case 1:
                boolean flag = true;
                int j = 3;
                for (int i = 1; i <= 3; i++) {
                    System.out.print("Enter UPI Number: ");
                    long number = sc.nextLong();
                    System.out.print("Enter UPI Pin: ");
                    int pin = sc.nextInt();

                    if (this.UPI_Number == number && this.UPI_pin == pin) {
                        flag = false;
                        System.out.println("Payment Successful...");
                        System.out.println("Order Placed Successfully!");
                        int orderid = random.nextInt(10000);
                        System.out.println("Your Order ID is: " + orderid);

                        for (Product p : buy) {
                            Order order = new Order(orderid, this.getusername(), p.getName(), p.getPrice(),
                                    LocalDateTime.now(), 1, "Ordered");
                            orders.add(order);
                        }
                        billing();
                        cart.clear();
                        buy.clear();
                        break;
                    } else {
                        j--;
                        if (j > 0) {
                            System.out.println(
                                    "Wrong UPI Number or UPI Pin. Available " + j + " more Chance(s). Try Again.");
                        }
                    }
                }
                if (flag) {
                    System.out.println("Payment Failed due to wrong credentials.");
                }
                break;

            case 2:
                System.out.println("Cash on delivery Selected.");
                System.out.println("Order Placed Successfully!");
                int orderid = random.nextInt(10000);
                System.out.println("Your Order ID is: " + orderid);

                for (Product p : buy) {
                    Order order = new Order(orderid, this.getusername(), p.getName(), p.getPrice(), LocalDateTime.now(),
                            1, "Ordered");
                    orders.add(order);
                }
                billing();
                cart.clear();
                buy.clear();
                break;

            case 3:
                break;

            default:
                System.out.println("Invalid Choice.");
        }
    }

    public void filterProducts(ArrayList<Product> products, Scanner sc) {
        if (products.isEmpty()) {
            System.out.println("No Product Available.");
            return;
        }
        System.out.println("\n====== FILTER PRODUCT ======");
        System.out.println("1. Category");
        System.out.println("2. Price Range");
        System.out.print("Enter Choice : ");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                sc.nextLine();
                System.out.print("Enter Category : ");
                String category = sc.nextLine();
                boolean found = false;
                System.out.println("\n------ Filter Result ------");
                for (Product p : products) {
                    if (p.getCategory().equalsIgnoreCase(category)) {
                        if (p instanceof FetureElectronic) {
                            ((FetureElectronic) p).displayFeature();
                        } else if (p instanceof FetureGadjet) {
                            ((FetureGadjet) p).displayFeature();
                        } else if (p instanceof FetureFashion) {
                            ((FetureFashion) p).displayFeature();
                        } else {
                            p.display();
                        }
                        System.out.println("--------------------------------");
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No Product Found.");
                }
                break;

            case 2:
                System.out.print("Enter Minimum Price : ");
                double min = sc.nextDouble();
                System.out.print("Enter Maximum Price : ");
                double max = sc.nextDouble();
                boolean flag = false;
                System.out.println("\n------ Filter Result ------");
                for (Product p : products) {
                    if (p.getPrice() >= min && p.getPrice() <= max) {
                        if (p instanceof FetureElectronic) {
                            ((FetureElectronic) p).displayFeature();
                        } else if (p instanceof FetureGadjet) {
                            ((FetureGadjet) p).displayFeature();
                        } else if (p instanceof FetureFashion) {
                            ((FetureFashion) p).displayFeature();
                        } else {
                            p.display();
                        }
                        System.out.println("--------------------------------");
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("No Product Found.");
                }
                break;

            default:
                System.out.println("Invalid Choice.");
        }
    }

    public void viewProfile() {
        System.out.println("\n========== MY PROFILE ==========");
        System.out.println("Username      : " + username);
        System.out.println("Mobile Number : " + mobile);
        System.out.println("UPI Number    : " + UPI_Number);
        System.out.println("Address       : " + address);
        StringBuilder pass = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            pass.append("*");
        }
        System.out.println("Password      : " + pass.toString());
        System.out.println("================================");
    }

    public void trackOrder(ArrayList<Order> orders, Scanner sc) {
        if (orders.isEmpty()) {
            System.out.println("No Orders Found.");
            return;
        }

        System.out.print("Enter Order ID : ");
        int id = sc.nextInt();
        boolean found = false;

        for (Order o : orders) {
            if (o.getOrderId() == id && o.getCustomerName().equals(this.username)) {
                System.out.println("\n========== ORDER TRACKING ==========");
                System.out.println("Order ID : " + o.getOrderId());
                System.out.println("Status   : " + o.getStatus());

                if (o.getStatus().equalsIgnoreCase("Ordered")) {
                    System.out.println("📦 Your Order has been Placed.");
                } else if (o.getStatus().equalsIgnoreCase("Packed")) {
                    System.out.println("📦 Your Order has been Packed.");
                } else if (o.getStatus().equalsIgnoreCase("Shipped")) {
                    System.out.println("🚚 Your Order has been Shipped.");
                } else if (o.getStatus().equalsIgnoreCase("Out For Delivery")) {
                    System.out.println("🛵 Your Order is Out For Delivery.");
                } else if (o.getStatus().equalsIgnoreCase("Delivered")) {
                    System.out.println("✅ Your Order has been Delivered.");
                } else if (o.getStatus().equalsIgnoreCase("Cancelled")) {
                    System.out.println("❌ Order Cancelled.");
                } else if (o.getStatus().equalsIgnoreCase("Returned")) {
                    System.out.println("↩️ Product Returned.");
                }

                System.out.println("===================================");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Order Not Found.");
        }
    }
}

// ---------------- MAIN CLASS ----------------
public class Flipkartoops {

    public static void loadOrders(ArrayList<Order> orders) {
        File file = new File("Order.txt");
        if (!file.exists())
            return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            @SuppressWarnings("unchecked")
            ArrayList<Order> list = (ArrayList<Order>) ois.readObject();
            orders.addAll(list);
        } catch (Exception e) {
            System.out.println("Error loading orders: " + e.getMessage());
        }
    }

    public static void loadCustomer(ArrayList<Customer> customers) {
        File file = new File("customers.txt");
        if (!file.exists())
            return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            @SuppressWarnings("unchecked")
            ArrayList<Customer> loadedCustomers = (ArrayList<Customer>) ois.readObject();
            customers.addAll(loadedCustomers);
        } catch (Exception e) {
            System.out.println("Error loading customers: " + e.getMessage());
        }
    }

    public static void loadProducts(ArrayList<Product> products) {
        File file = new File("products.txt");
        if (!file.exists())
            return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            @SuppressWarnings("unchecked")
            ArrayList<Product> loadedProducts = (ArrayList<Product>) ois.readObject();
            products.addAll(loadedProducts);
        } catch (Exception e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
    }

    public static void saveCustomer(ArrayList<Customer> customers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("customers.txt"))) {
            oos.writeObject(customers);
        } catch (IOException e) {
            System.out.println("Error saving customers: " + e.getMessage());
        }
    }

    public static void saveProducts(ArrayList<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("products.txt"))) {
            oos.writeObject(products);
        } catch (IOException e) {
            System.out.println("Error saving products: " + e.getMessage());
        }
    }

    public static void saveOrder(ArrayList<Order> orders) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Order.txt"))) {
            oos.writeObject(orders);
        } catch (IOException e) {
            System.out.println("Error saving orders: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();

        loadOrders(orders);
        loadCustomer(customers);
        loadProducts(products);

        Admin admin = new Admin("admin", "1234");
        int choice;

        do {
            System.out.println(
                    "\n<<<<<<<<<<========================= VISHAL MART ============================>>>>>>>>>>");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Register");
            System.out.println("3. Customer Login");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.println();
                    System.out.print("Enter Admin Username: ");
                    String aUser = sc.nextLine();
                    System.out.print("Enter Admin Password: ");
                    String aPass = sc.nextLine();

                    if (aUser.equals(admin.getUsername()) && aPass.equals(admin.getPassword())) {
                        System.out.println("Admin Login Successful!");
                        admin.newOrderNotification(orders);
                        int adminChoice;
                        do {
                            System.out.println("\n******=============== ADMIN MENU ===============******");
                            System.out.println("1. Add Product");
                            System.out.println("2. View Products");
                            System.out.println("3. Update Product");
                            System.out.println("4. Remove Product");
                            System.out.println("5. Update Stock");
                            System.out.println("6. Add Stock");
                            System.out.println("7. Low Stock Alert");
                            System.out.println("8. Out Of Stock");
                            System.out.println("9. Sales Report");
                            System.out.println("10. Update Order status");
                            System.out.println("11. Logout");
                            System.out.println();
                            System.out.print("Enter Choice: ");
                            adminChoice = sc.nextInt();
                            System.out.println();

                            switch (adminChoice) {
                                case 1:
                                    admin.addProduct(products, sc);
                                    break;
                                case 2:
                                    admin.viewProducts(products);
                                    break;
                                case 3:
                                    admin.updateProduct(products, sc);
                                    break;
                                case 4:
                                    admin.removeProduct(products, sc);
                                    break;
                                case 5:
                                    admin.updateStock(products, sc);
                                    break;
                                case 6:
                                    admin.addStock(products, sc);
                                    break;
                                case 7:
                                    admin.lowStockAlert(products);
                                    break;
                                case 8:
                                    admin.outOfStock(products);
                                    break;
                                case 9:
                                    admin.salesReport(orders);
                                    break;
                                case 10:
                                    admin.updateOrderStatus(orders, sc);
                                    break;
                                case 11:
                                    System.out.println("Thank you");
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                            }
                        } while (adminChoice != 11);
                    } else {
                        System.out.println("Invalid Admin name or Password!!");
                    }
                    break;

                case 2:
                    sc.nextLine();
                    System.out.println("******============ Customer Registration ============******\n");
                    System.out.println("-----OTP Verification------");
                    System.out.print("Enter Mobile Number: ");
                    long mob = sc.nextLong();

                    int i = 3;
                    boolean verified = false;

                    while (i > 0) {
                        int otp = 100000 + random.nextInt(900000);
                        long otpTime = System.currentTimeMillis();
                        System.out.println("Generated OTP: " + otp);
                        System.out.print("Enter OTP: ");
                        int userotp = sc.nextInt();

                        long otpcurrent = System.currentTimeMillis();
                        if (otp == userotp) {
                            if (otpcurrent - otpTime < 60000) {
                                System.out.println("OTP Verified Successfully.");
                                verified = true;
                                break;
                            } else {
                                System.out.println("OTP Expired..!!!");
                                break;
                            }
                        } else {
                            i--;
                            System.out.println("Invalid OTP.");
                            if (i > 0) {
                                System.out.println("Try Again More " + i + " times.");
                            }
                        }
                    }

                    if (!verified) {
                        System.out.println("Registration Failed.");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Create Username: ");
                    String user = sc.nextLine();
                    System.out.print("Create Password: ");
                    String pass = sc.nextLine();
                    System.out.print("Enter UPI Number: ");
                    long number = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Enter UPI pin: ");
                    int pin = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    Customer c = new Customer(user, pass, mob, number, pin, address);
                    customers.add(c);
                    System.out.println("Registration Successful!");
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter Username: ");
                    String loginUser = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String loginPass = sc.nextLine();
                    Customer loggedInCustomer = null;

                    for (Customer cust : customers) {
                        if (cust.getUsername().equals(loginUser) && cust.getPassword().equals(loginPass)) {
                            loggedInCustomer = cust;
                            break;
                        }
                    }

                    if (loggedInCustomer != null) {
                        System.out.println("Login Successful!");
                        int customerChoice;
                        do {
                            System.out.println(
                                    "\n<<<<<<<<<<================== CUSTOMER MENU ====================>>>>>>>>>>");
                            System.out.println("1. View Products");
                            System.out.println("2. Search Product");
                            System.out.println("3. Add To Cart");
                            System.out.println("4. View Cart");
                            System.out.println("5. View History");
                            System.out.println("6. Buy Product");
                            System.out.println("7. Filter Products");
                            System.out.println("8. View Profile");
                            System.out.println("9. Order Tracking");
                            System.out.println("10. Logout");
                            System.out.println();
                            System.out.print("Enter Choice: ");
                            customerChoice = sc.nextInt();
                            System.out.println();

                            switch (customerChoice) {
                                case 1:
                                    loggedInCustomer.viewProducts(products);
                                    break;
                                case 2:
                                    loggedInCustomer.searchProduct(products, sc);
                                    break;
                                case 3:
                                    loggedInCustomer.addToCart(products, sc);
                                    break;
                                case 4:
                                    loggedInCustomer.viewCart();
                                    break;
                                case 5:
                                    loggedInCustomer.viewHistory();
                                    break;
                                case 6:
                                    loggedInCustomer.buyProduct(customers, orders, sc);
                                    break;
                                case 7:
                                    loggedInCustomer.filterProducts(products, sc);
                                    break;
                                case 8:
                                    loggedInCustomer.viewProfile();
                                    break;
                                case 9:
                                    loggedInCustomer.trackOrder(orders, sc);
                                    break;
                                case 10:
                                    System.out.println("Customer Logout!");
                                    break;
                                default:
                                    System.out.println("Invalid Choice!");
                            }
                        } while (customerChoice != 10);
                    } else {
                        System.out.println("Invalid Username or Password!");
                    }
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 4);

        saveProducts(products);
        saveCustomer(customers);
        saveOrder(orders);
        sc.close();
    }
}
