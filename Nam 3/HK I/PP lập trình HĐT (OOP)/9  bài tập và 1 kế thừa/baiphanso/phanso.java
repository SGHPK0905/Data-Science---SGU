public class phanso {
    private int tuso ;
    private int mauso ; 

    //constructor
    public phanso (){
        tuso = 0 ;
        mauso = 1 ; 

    }
    public phanso (int tu , int mau){
        tuso = tu ; 
        if (mau!=0) mauso = mau ; 
        else{
            System.out.println("mau so khong hop le, gan mau so bang 1");
            mauso = 1 ;
        }
    }
    public phanso cong(phanso p){
        int tu = tuso * p.mauso + mauso * p.tuso ;
        int mau = mauso * p.mauso ;
        return new phanso(tu,mau);
    }
    private int usc (int a , int b ){
        a = Math.abs(a);
        b = Math.abs(b);
        if(b==0) return a ;
        return usc (b,a %b);
    }
    public void rutgon(){
        int uscln = usc(tuso,mauso);
        tuso/= uscln;
        mauso/=uscln;
    }
    public int sosanh(phanso p){
        int a = tuso * p.mauso;
        int b = mauso * p.tuso;
        if(a>b) return 1 ; 
        else if(a<b) return -1 ;
        else return 0 ;
    }
    public String toString(){
        return tuso + "/" + mauso;
    }
}

