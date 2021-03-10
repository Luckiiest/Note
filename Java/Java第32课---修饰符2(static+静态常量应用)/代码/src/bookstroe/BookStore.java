package bookstroe;

/**书店类*/
public class BookStore {

    private static final int BOOKSTROE_ADMIN = 0;
    private static final int BOOKSTROE_VIP = 1;
    private static final int BOOKSTROE_NORMAL = 2;

    public void buyBook(float price,int identity){
        switch(identity){
            case BookStore.BOOKSTROE_ADMIN:
                System.out.println("尊敬的书店管理员，您购买的图书应付款:"+price*0.5);
                break;
            case BookStore.BOOKSTROE_VIP:
                System.out.println("尊敬的书店VIP客户，您购买的图书应付款:"+price*0.8);
                break;
            case BookStore.BOOKSTROE_NORMAL:
                System.out.println("尊敬的普通用户，您购买的图书应付款:"+price);
                break;
            default:
                System.out.println("对不起，系统查不到您的身份，不许买书");
        }
    }
}
