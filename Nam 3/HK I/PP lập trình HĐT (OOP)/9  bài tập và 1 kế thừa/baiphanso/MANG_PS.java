
import java.util.Random;

public class MANG_PS{ // mảng phân số có n phần tử , 
    phanso[] mang = new phanso[100]; // chưa phải 100 đối tượng 
    int n ;

    public MANG_PS (int length){
        n = length;
        int t , m ;
        Random r = new Random();// dùng được random phải import thư viện import java.util.Random;
        for (int i = 0 ; i < n ; i++)
    {
        t = r.nextInt(10);
        m = r.nextInt(10) + 1; // +1 cho mẫu khác không 
        mang[i] = new phanso(t,m); // lúc này nó mới là đối tượng 
    }
    }
    public int timkiem(phanso ps)// phương thức trả về có hay không có , có =1 , không có =-1
    {
        for(int i = 0 ; i < n ; i++)
        if (mang[i].sosanh(ps) == 0) return i ;
        return -1 ;
    }
    @Override
    public String toString()// phương thức của lớp cha của các lớp nên có kí hiệu override, toString này là của mảng phân số 
    {
        String temp = " ";
        for(int i = 0 ; i < n ; i++)
        {
            temp += mang[i] . toString();// toString này của là phân số 
            temp += " ";
        }
        return temp;
    }
}