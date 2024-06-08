import java.util.*;
class Product{
    private String name;     
    private double cost;
    private int quantity;
    private UUID id;
    Product(String name,double cost,int quantity){
        this.id=UUID.randomUUID();       
        this.name=name;        
        this.cost=cost;      
        this.quantity=quantity;     
    }
 public String toString(){
    String s=this.name+"-";
    s=s+this.quantity+"\n";
    return s;
 }
 public String getname(){
    return name;
 }
 public int getquantity(){
    return quantity;
 }
 public double getcost(){
    return cost;
 }
public UUID getid(){
    return id;
}
public double gettotalprice(int quantity){
    return this.cost*this.quantity;
}
}
class customer{
    private String name;
    private String address;
    private String email;
    private UUID custid;
    customer(String name,String address,String email){
        this.custid=UUID.randomUUID();
        this.name=name;
        this.address=address;
        this.email=email;
    }
 public String getname(){
    return name;
 }
 public String getaddress(){
    return address;
 }
 public String getemail(){
    return email;
 }
public UUID getcustid(){
    return custid;
}
}
class shoppingcart{
   private List<Product>items;
   shoppingcart(){
    this.items=new ArrayList<>();
   }
   public void addproduct(Product product){
    items.add(product);
   }
   public void removeproduct(Product product){
    items.remove(product);
   }
   public double calculatetotalmrp(){
    double mrp=0;
    for(Product item:items){
      mrp+=item.gettotalprice(item.getquantity());
    }
    return mrp;
   }
    }
    interface payments{
   void procedure(double amt);
}
class creditcard implements payments{
    String cardno;
    String name;
    creditcard(String cardno,String name)
    {
        this.cardno=cardno;
        this.name=name;
    }
    public void procedure(double amount){
        System.out.println("Creditcard payment of Rs"+amount);
    }
}
class debitcard implements payments{
    String cardno;
    String name;
    debitcard(String cardno,String name)
    {
        this.cardno=cardno;
        this.name=name;
    }
    public void procedure(double amount){
        System.out.println("Debit card payment of Rs"+amount);
    }
}
class netbanking implements payments{
    String bankname;
    String accno;
    netbanking(String bankname,String accno)
    {
        this.bankname=bankname;
        this.accno=accno;
    }
    public void procedure(double amount){
        System.out.println("credit card payment of Rs"+amount);
    }
}
class main{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        shoppingcart s1=new shoppingcart();
        System.out.println("enter the product details:name,price and quantity");
        String name,choice;double price,total;int quantity;
    
        do{
            System.out.println("name:");
             name=sc.next();
            System.out.println("price:");
            price=sc.nextDouble();
            System.out.println("quantity:");
             quantity=sc.nextInt();
        Product p1=new Product(name,price,quantity);
        s1.addproduct(p1);
        System.out.println("\nProduct details");
        System.out.println("Product ID: " + p1.getid());
        System.out.println("Name: " + p1.getname());
        System.out.println("Address: $" + p1.getcost());
        System.out.println("Quantity: " + p1.getquantity());
        double prices=p1.gettotalprice(quantity);
        System.out.println("Total price of a product-"+prices);
         System.out.println();
        System.out.print("add another product?(yes\no):");
         choice=sc.next();
       }while(choice.equalsIgnoreCase("yes")); 
          total=s1.calculatetotalmrp();
        System.out.println("Total cost-"+total);
        System.out.println("enter the customer details:name,address and email");
          System.out.println("name:");
            String custname=sc.next();
            System.out.println("address:");
            String address=sc.next();
            System.out.println("email:");
            String email=sc.next(); 
         customer c1=new customer(custname,address,email);
         System.out.println("\nCustomer details");
        System.out.println("Customer ID: " + c1.getcustid());
        System.out.println("Name: " + c1.getname());
        System.out.println("Address: $" + c1.getaddress());
        System.out.println("Email: " + c1.getemail());
        int ch;
        System.out.println("1 for credit card payment,2 for debit card payment,3 for netbanking");
        System.out.println("enter the mode of payment u want");
        ch=sc.nextInt();
        switch(ch)
        {
        case 1:System.out.println("enter the card number");
               System.out.println("enter the bankholders name");
               String cardno=sc.next();
               String name2=sc.next();
               creditcard obj=new creditcard(cardno,name2);
               obj.procedure(total);
               break;
        case 2:System.out.println("enter the card number");
               System.out.println("enter the bankholders name");
               String cardno1=sc.nextLine();
               String name1=sc.nextLine();
               debitcard obj1=new debitcard(cardno1,name1);
               obj1.procedure(total);
               break;
        case 3: System.out.println("enter the card number");
               System.out.println("enter the bankholders name");
               String bankno=sc.nextLine();
               String accno=sc.nextLine();
               netbanking obj2=new netbanking(bankno,accno);
               obj2.procedure(total);
               break;  
        default:System.out.println("invalid choice");      
        }
    }
}