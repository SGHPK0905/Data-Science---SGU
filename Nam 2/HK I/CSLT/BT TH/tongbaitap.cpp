#include <iostream>
#include <cmath>
using namespace std;

// Hàm tính tổng 2 số
void tinhTong() {
    int a, b;
    cout << "Nhap so thu nhat: ";
    cin >> a;
    cout << "Nhap so thu hai: ";
    cin >> b;
    cout << "Tong hai so la: " << a + b << endl;
}

// Hàm tìm số lớn nhất trong 3 số
void timMax() {
    int a, b, c;
    cout << "Nhap ba so: ";
    cin >> a >> b >> c;
    int max = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
    cout << "So lon nhat la: " << max << endl;
}

// Hàm kiểm tra số nguyên tố
void kiemTraSoNguyenTo() {
    int n;
    cout << "Nhap so can kiem tra: ";
    cin >> n;
    bool isPrime = true;
    
    if (n < 2) {
        isPrime = false;
    } else {
        for (int i = 2; i <= sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
    }

    if (isPrime)
        cout << n << " la so nguyen to." << endl;
    else
        cout << n << " khong phai la so nguyen to." << endl;
}

int main() {
    
    int choice;

    do {
        // Hiển thị menu
        cout << "\n=== MENU ===" << endl;
        cout << "1. Tinh tong 2 so" << endl;
        cout << "2. Tim so lon nhat" << endl;
        cout << "3. Kiem tra so nguyen to" << endl;
        cout << "0. Thoat" << endl;
        cout << "Lua chon cua ban: ";
        cin >> choice;

        // Sử dụng switch-case để xử lý lựa chọn
        switch (choice) {
            case 1:
                tinhTong();
                break;
            case 2:
                timMax();
                break;
            case 3:
                kiemTraSoNguyenTo();
                break;
            case 0:
                cout << "Thoat chuong trinh." << endl;
                break;
            default:
                cout << "Lua chon khong hop le, vui long thu lai." << endl;
        }
    } while (choice != 0);

system("pause");
    return 0;
}
