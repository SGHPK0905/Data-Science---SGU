import functools

# Decorator để ghi log giao dịch
def ghi_log(func):
    @functools.wraps(func)
    def wrapper(*args, **kwargs):
        try:
            ket_qua = func(*args, **kwargs)
            print(f"[LOG] Giao dịch thành công: {func.__name__} với đối số: {args[1:]}, kết quả: {ket_qua}")
            return ket_qua
        except Exception as e:
            print(f"[LỖI] Giao dịch thất bại: {func.__name__} với đối số: {args[1:]}, lỗi: {e}")
            raise e
    return wrapper

class TaiKhoan:
    def __init__(self, so_du_ban_dau=0):
        self.__so_du = so_du_ban_dau
    
    @ghi_log
    def nap_tien(self, so_tien):
        if so_tien <= 0:
            raise ValueError("Số tiền nạp phải lớn hơn 0")
        self.__so_du += so_tien
        return self.__so_du
    
    @ghi_log
    def rut_tien(self, so_tien):
        if so_tien <= 0:
            raise ValueError("Số tiền rút phải lớn hơn 0")
        if so_tien > self.__so_du:
            raise ValueError("Số dư không đủ")
        self.__so_du -= so_tien
        return self.__so_du
    
    def lay_so_du(self):
        return self.__so_du

class QuanLyGiaoDich:
    def __init__(self):
        self.danh_sach_tai_khoan = []
    
    def them_tai_khoan(self, tai_khoan):
        self.danh_sach_tai_khoan.append(tai_khoan)
    
    def thuc_hien_giao_dich(self, func, tai_khoan, so_tien):
        try:
            func(tai_khoan, so_tien)
        except Exception as e:
            print(f"Giao dịch thất bại: {e}")

# Kiểm tra hệ thống
tk1 = TaiKhoan(100)
tk2 = TaiKhoan(200)

quan_ly = QuanLyGiaoDich()
quan_ly.them_tai_khoan(tk1)
quan_ly.them_tai_khoan(tk2)

# Giao dịch hợp lệ
quan_ly.thuc_hien_giao_dich(TaiKhoan.nap_tien, tk1, 50)  # Nạp 50 vào tài khoản tk1
quan_ly.thuc_hien_giao_dich(TaiKhoan.rut_tien, tk2, 100) # Rút 100 từ tài khoản tk2

# Giao dịch thất bại
quan_ly.thuc_hien_giao_dich(TaiKhoan.rut_tien, tk1, 500) # Rút quá số dư