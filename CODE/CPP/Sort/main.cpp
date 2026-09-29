#include <iostream>
#include <fstream>
#include <chrono>   // Thư viện đo thời gian
#include <algorithm> // Thư viện cho hàm swap

using namespace std;
using namespace chrono;

/* ================= CẤU HÌNH ================= */
// Kích thước tối đa: 1 triệu + 5 phần tử dự phòng
const int MAX = 1000005; 

/* ================= BIẾN TOÀN CỤC (QUAN TRỌNG) ================= */
// Khai báo ở đây để dùng vùng nhớ Static (chứa được dữ liệu lớn)
// Nếu để trong main sẽ bị lỗi Stack Overflow ngay lập tức
int original[MAX];
int arrSelection[MAX];
int arrInsertion[MAX];
int arrBubble[MAX];

/* ================= CÁC HÀM SẮP XẾP ================= */

// 1. Selection Sort
void selectionSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        int minPos = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minPos]) {
                minPos = j;
            }
        }
        if (minPos != i) {
            swap(arr[i], arr[minPos]);
        }
    }
}

// 2. Insertion Sort
void insertionSort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

// 3. Bubble Sort
void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        bool swapped = false;
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr[j], arr[j + 1]);
                swapped = true;
            }
        }
        if (!swapped) break;
    }
}

/* ================= HÀM MAIN ================= */
int main() {
    int n;

    // --- BƯỚC 1: ĐỌC FILE ---
    // Đảm bảo bạn đã tạo file input_1000000.txt cùng thư mục với file code
    ifstream inFile("input_1000000.txt");
    
    if (!inFile) {
        cout << "LOI: Khong tim thay file input_1000000.txt" << endl;
        cout << "Hay kiem tra lai ten file hoac duong dan." << endl;
        return 1;
    }

    inFile >> n; // Đọc số lượng phần tử
    
    // Kiểm tra an toàn
    if (n > MAX) {
        cout << "LOI: File input co " << n << " phan tu, vuot qua MAX (" << MAX << ")" << endl;
        return 1;
    }

    cout << "Dang doc " << n << " so tu file..." << endl;
    for (int i = 0; i < n; i++) {
        inFile >> original[i];
    }
    inFile.close();
    cout << "Doc file xong!" << endl;

    // --- BƯỚC 2: SAO CHÉP MẢNG ---
    cout << "Dang sao chep du lieu ra 3 mang..." << endl;
    for (int i = 0; i < n; i++) {
        arrSelection[i] = original[i];
        arrInsertion[i] = original[i];
        arrBubble[i]    = original[i];
    }

    cout << "==================================================" << endl;
    cout << "LUU Y: Voi 1.000.000 phan tu, thoi gian chay se RẤT LAU." << endl;
    cout << "Bubble Sort co the mat hang gio dong ho de chay xong." << endl;
    cout << "Hay kien nhan cho doi..." << endl;
    cout << "==================================================" << endl;

    // --- BƯỚC 3: CHẠY INSERTION SORT (Thường nhanh nhất trong 3 cái) ---
    cout << "1. Dang chay Insertion Sort..." << endl;
    auto startIns = high_resolution_clock::now();
    insertionSort(arrInsertion, n);
    auto endIns = high_resolution_clock::now();
    double timeInsertion = duration<double, milli>(endIns - startIns).count();
    cout << "-> Xong Insertion Sort: " << timeInsertion << " ms" << endl;

    // --- BƯỚC 4: CHẠY SELECTION SORT ---
    cout << "2. Dang chay Selection Sort..." << endl;
    auto startSel = high_resolution_clock::now();
    selectionSort(arrSelection, n);
    auto endSel = high_resolution_clock::now();
    double timeSelection = duration<double, milli>(endSel - startSel).count();
    cout << "-> Xong Selection Sort: " << timeSelection << " ms" << endl;

    // --- BƯỚC 5: CHẠY BUBBLE SORT ---
    cout << "3. Dang chay Bubble Sort (Cai nay lau nhat)..." << endl;
    auto startBub = high_resolution_clock::now();
    bubbleSort(arrBubble, n);
    auto endBub = high_resolution_clock::now();
    double timeBubble = duration<double, milli>(endBub - startBub).count();
    cout << "-> Xong Bubble Sort: " << timeBubble << " ms" << endl;

    // --- BƯỚC 6: GHI FILE OUTPUT ---
    cout << "Dang ghi ket qua ra file output_1000000.txt..." << endl;
    ofstream outFile("output_1000000.txt");
    
    outFile << "Input size: " << n << endl << endl;
    outFile << "Insertion Sort time: " << timeInsertion << " ms" << endl;
    outFile << "Selection Sort time: " << timeSelection << " ms" << endl;
    outFile << "Bubble Sort time: " << timeBubble << " ms" << endl << endl;

    // Ghi mảng đã sắp xếp để kiểm tra (lấy mảng Insertion làm mẫu)
    outFile << "Sorted Array Sample (Insertion Sort Output):" << endl;
    for (int i = 0; i < n; i++) {
        outFile << arrInsertion[i] << " ";
    }
    
    outFile.close();
    cout << "HOAN TAT! Vui long kiem tra file output_1000000.txt" << endl;

    return 0;
}