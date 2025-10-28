import math

# Nhập vào bán kính
r = float(input("Nhập bán kính r: "))

# Tính chu vi và diện tích
cv = 2 * math.pi * r
dt = math.pi * r**2

# Xuất kết quả
print("Chu vi hình tròn =", cv)
print("Diện tích hình tròn =", dt)