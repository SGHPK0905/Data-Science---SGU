#include <iostream>
#include <string>
#include <cmath>

#define MAX 1000000
using namespace std;

struct Book {
    int stt;
    int maSach;
    string tenSach;
    int soLuong;
    double donGia;
    double thanhTien;
    double donGiaBan;
};

Book danhSach[MAX];
int soLuongSach = 0;

/*// Hàm định dạng tiền
string formatMoney(double money) {
    string numStr = to_string(money);
    size_t dotPos = numStr.find('.');

    if (dotPos != string::npos) {
        // Kiểm tra nếu phần thập phân bằng 0
        string fractional = numStr.substr(dotPos + 1);
        if (stoi(fractional) == 0) {
            numStr = numStr.substr(0, dotPos); // Loại bỏ phần thập phân nếu = 0
        } else {
            numStr = numStr.substr(0, dotPos + 3); // Giữ lại 2 chữ số thập phân
        }
    }

    int len = numStr.length();
    int insertPosition = len - 3;

    while (insertPosition > 0) {
        numStr.insert(insertPosition, ",");
        insertPosition -= 3;
    }

    return numStr;
}*/


// Hàm cập nhật số thứ tự
void capNhatSoThuTu() {
    for (int i = 0; i < soLuongSach; i++) {
        danhSach[i].stt = i + 1;
    }
}

// Hàm nhập danh sách sách
void nhapDanhSach() {
    int n;
    cout << "Nhap so luong sach: ";
    cin >> n;
    for (int i = 0; i < n; i++) {
        if (soLuongSach >= MAX) {
            cout << "Danh sach da day, khong the them sach moi.\n";
            break;
        }

        Book sach;
        cout << "Nhap ma sach: ";
        cin >> sach.maSach;
        cin.ignore();
        cout << "Nhap ten sach: ";
        getline(cin, sach.tenSach);
        cout << "Nhap so luong ton kho: ";
        cin >> sach.soLuong;
        cout << "Nhap don gia: ";
        cin >> sach.donGia;
        cout << "Nhap don gia ban: ";
        cin >> sach.donGiaBan;

        sach.thanhTien = sach.soLuong * sach.donGia;
        danhSach[soLuongSach++] = sach;
    }
    capNhatSoThuTu(); // Cập nhật số thứ tự sau khi thêm sách
}

// Hàm thêm sách
void themSach() {
    if (soLuongSach >= MAX) {
        cout << "Danh sach da day, khong the them sach moi.\n";
        return;
    }

    Book sach;
    cout << "Nhap ma sach: ";
    cin >> sach.maSach;
    cin.ignore();
    cout << "Nhap ten sach: ";
    getline(cin, sach.tenSach);
    cout << "Nhap so luong ton kho: ";
    cin >> sach.soLuong;
    cout << "Nhap don gia: ";
    cin >> sach.donGia;
    cout << "Nhap don gia ban: ";
    cin >> sach.donGiaBan;

    sach.thanhTien = sach.soLuong * sach.donGia;
    danhSach[soLuongSach++] = sach;
    capNhatSoThuTu(); // Cập nhật số thứ tự sau khi thêm sách
}

// Hàm xóa sách
void xoaSach() {
    int maSach;
    cout << "Nhap ma sach can xoa: ";
    cin >> maSach;

    int viTri = -1;
    for (int i = 0; i < soLuongSach; i++) {
        if (danhSach[i].maSach == maSach) {
            viTri = i;
            break;
        }
    }

    if (viTri != -1) {
        for (int i = viTri; i < soLuongSach - 1; i++) {
            danhSach[i] = danhSach[i + 1];
        }
        soLuongSach--;
        capNhatSoThuTu(); // Cập nhật số thứ tự sau khi xóa sách
        cout << "Xoa sach thanh cong!\n";
    } else {
        cout << "Khong tim thay sach co ma " << maSach << "!\n";
    }
}

// Hàm sắp xếp danh sách theo đơn giá bán giảm dần và cập nhật số thứ tự
void sapXep() {
    for (int i = 0; i < soLuongSach - 1; i++) {
        for (int j = i + 1; j < soLuongSach; j++) {
            if (danhSach[i].donGiaBan < danhSach[j].donGiaBan) {
                Book temp = danhSach[i];
                danhSach[i] = danhSach[j];
                danhSach[j] = temp;
            }
        }
    }
    capNhatSoThuTu(); // Đảm bảo số thứ tự vẫn từ bé đến lớn sau sắp xếp
    cout << "Da sap xep danh sach.\n";
}

// Hàm in tổng giá trị tồn kho
#include <iomanip> // Thư viện hỗ trợ định dạng số

void inTonKho() {
    int tongSoLuong = 0;
    double tongGiaTri = 0;

    for (int i = 0; i < soLuongSach; i++) {
        tongSoLuong += danhSach[i].soLuong;
        tongGiaTri += danhSach[i].thanhTien;
    }

    cout << "Ton kho sach:\n";
    cout << "- So luong: " << tongSoLuong << "\n";
    cout << "- So tien: " << fixed << setprecision(0) << tongGiaTri << "\n"; // Hiển thị số lớn mà không có e+
}


// Hàm in danh sách sách
void inDanhSach() {
    cout << "Danh sach hang hoa:\n";
    for (int i = 0; i < soLuongSach; i++) {
        const Book &sach = danhSach[i];
        cout << "So thu tu: " << sach.stt << "\n";
        cout << "- Ma sach: " << sach.maSach << " Ten sach: " << sach.tenSach << "\n";
        cout << "- So luong ton kho: " << sach.soLuong << " Don gia: " 
             << fixed << setprecision(0) << sach.donGia << "\n";
        cout << "- Thanh tien: " << fixed << setprecision(0) << sach.thanhTien << "\n";
        cout << "- Don gia ban: " << fixed << setprecision(0) << sach.donGiaBan << "\n";
    }
}


void timKiemSach() {
    cout << "\n===== TIM KIEM SACH =====\n";
    cout << "Nhap 1 de tim kiem theo ma sach\n";
    cout << "Nhap 2 de tim kiem theo ten sach\n";
    int luaChon;
    cin >> luaChon;

    if (luaChon == 1) { // Tìm theo mã sách
        int maSach;
        cout << "Nhap ma sach: ";
        cin >> maSach;

        bool timThay = false;
        for (int i = 0; i < soLuongSach; i++) {
            if (danhSach[i].maSach == maSach) {
                timThay = true;
                const Book &sach = danhSach[i];
                cout << "\nKet qua tim kiem:\n";
                cout << "- So thu tu: " << sach.stt << "\n";
                cout << "- Ma sach: " << sach.maSach << " Ten sach: " << sach.tenSach << "\n";
                cout << "- So luong ton kho: " << sach.soLuong << " Don gia: \n";
                cout << "- Thanh tien: \n";
                cout << "- Don gia ban: \n";
                break;
            }
        }

        if (!timThay) {
            cout << "Khong tim thay ma sach " << maSach << " trong danh sach.\n";
        }

    } else if (luaChon == 2) {
        cin.ignore();
        string tuKhoa;
        cout << "Nhap ten sach hoac tu khoa: ";
        getline(cin, tuKhoa);

        bool timThay = false;
        cout << "\nKet qua tim kiem:\n";
        for (int i = 0; i < soLuongSach; i++) {
            if (danhSach[i].tenSach.find(tuKhoa) != string::npos) { 
                timThay = true;
                const Book &sach = danhSach[i];
                cout << "- So thu tu: " << sach.stt << "\n";
                cout << "- Ma sach: " << sach.maSach << " Ten sach: " << sach.tenSach << "\n";
                cout << "- So luong ton kho: " << sach.soLuong << " Don gia: \n";
                cout << "- Thanh tien: \n";
                cout << "- Don gia ban: \n";
                cout << "-------------------------\n";
            }
        }

        if (!timThay) {
            cout << "Khong tim thay sach co tu khoa \"" << tuKhoa << "\" trong danh sach.\n";
        }

    } else {
        cout << "Lua chon khong hop le.\n";
    }
}

// Menu chính
int main() {
    int luaChon;
    do {
        cout << "\n===== MENU =====\n";
        cout << "1. Nhap danh sach mat hang\n";
        cout << "2. Them mot cuon sach\n";
        cout << "3. Xoa mot cuon sach\n";
        cout << "4. Sap xep danh sach\n";
        cout << "5. In tong gia tri ton kho\n";
        cout << "6. In danh sach hang hoa\n";
        cout << "7. Tim kiem sach theo ten hoac ma sach\n";
        cout << "0. Thoat\n";
        cout << "Lua chon: ";
        cin >> luaChon;

        switch (luaChon) {
            case 1:
                nhapDanhSach();
                break;
            case 2:
                themSach();
                break;
            case 3:
                xoaSach();
                break;
            case 4:
                sapXep();
                break;
            case 5:
                inTonKho();
                break;
            case 6:
                inDanhSach();
                break;
            case 7:
                timKiemSach(); // Gọi hàm tìm kiếm
                break;
            case 0:
                cout << "Thoat chuong trinh!\n";
                break;
            default:
                cout << "Lua chon khong hop le.\n";
        }
    } while (luaChon != 0);

    return 0;
}