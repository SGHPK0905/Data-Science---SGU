#include <iostream>
using namespace std;

int main() {
    int a, b, ngay;
    cin >> a >> b; // Nhập giá trị của a và b

    switch (a) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            cout << "31 ngay" << endl;
            break;
        case 4: case 6: case 9: case 11:
            cout << "30 ngay" << endl;
            break;
        case 2:
            if ((b % 400 == 0) || (b % 4 == 0 && b % 100 != 0)) {
                cout << "29 ngay" << endl; // Năm nhuận
            } else {
                cout << "28 ngay" << endl; // Năm không nhuận
            }
            break;
        default:
            cout << "Thang khong hop le!" << endl;
    }

    system ("pause");
    return 0;
}
