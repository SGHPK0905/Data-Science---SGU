package ClassHinh;

import java.util.*;

public class TestHinh {

	public static List<hinh> randomShapes(int n) {
		List<hinh> list = new ArrayList<>();
		Random rnd = new Random();
		for (int i = 0; i < n; i++) {
			int type = rnd.nextInt(3);
			switch (type) {
				case 0: {
					double r = 1.0 + rnd.nextDouble() * 4.0;
					list.add(new HinhTron(r));
					break;
				}
				case 1: {
					double w = 1.0 + rnd.nextDouble() * 9.0;
					double h = 1.0 + rnd.nextDouble() * 9.0;
					list.add(new HinhChuNhat(w, h));
					break;
				}
				default: {
				
					double a = 1.0 + rnd.nextDouble() * 9.0;
					double b = 1.0 + rnd.nextDouble() * 9.0;
					double low = Math.abs(a - b) + 1e-3;
					double high = a + b - 1e-3;
					double c = low + rnd.nextDouble() * Math.max(0.001, (high - low));
				
					if (!(a + b > c && a + c > b && b + c > a)) {
						c = Math.min(a, b) * 0.9;
					}
					list.add(new HinhTamGiac(a, b, c));
					break;
				}
			}
		}
		return list;
	}

	// 1. Tổng diện tích
	public static double totalArea(List<hinh> list) {
		double sum = 0;
		for (hinh h : list) sum += h.dienTich();
		return sum;
	}

	// 2. TÌm hình có diện tích lớn nhất
	public static hinh maxArea(List<hinh> list) {
		if (list.isEmpty()) return null;
		hinh best = list.get(0);
		for (hinh h : list) if (h.dienTich() > best.dienTich()) best = h;
		return best;
	}

	// 3. Xóa hình có diện tích nhỏ nhất
	public static void removeMin(List<hinh> list) {
		if (list.isEmpty()) return;
		int idx = 0;
		double min = list.get(0).dienTich();
		for (int i = 1; i < list.size(); i++) {
			double s = list.get(i).dienTich();
			if (s < min) {
				min = s;
				idx = i;
			}
		}
		list.remove(idx);
	}

	public static void main(String[] args) {
		List<hinh> shapes = randomShapes(10);
		System.out.println("Danh sach hinh:");
		for (hinh h : shapes) System.out.println(" - " + h);

		double total = totalArea(shapes);
		System.out.printf("Tong dien tich: %.4f%n", total);

		hinh max = maxArea(shapes);
		System.out.println("Hinh co dien tich lon nhat: " + (max != null ? max : "khong co"));

		removeMin(shapes);
		System.out.println("Sau khi xoa hinh co dien tich nho nhat:");
		for (hinh h : shapes) System.out.println(" - " + h);
	}
}
