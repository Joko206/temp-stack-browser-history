package com.github.affandes.kuliah.pm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Kelas BrowserHistory untuk mengelola sejarah penjelajahan
class BrowserHistory {
    private List<String> history; // Menyimpan daftar history
    private int currentIndex; // Menyimpan indeks website saat ini

    // Konstruktor
    public BrowserHistory() {
        history = new ArrayList<>();
        currentIndex = -1; // Tidak ada website yang dikunjungi
    }

    // Fungsi untuk menampilkan semua history
    public void view() {
        if (history.isEmpty()) {
            System.out.println("History browser kosong.");
            return;
        }

        System.out.println("History Browser (dari yang terbaru):");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println((i + 1) + ". " + history.get(i));
        }
    }

    // Fungsi untuk menambahkan website baru ke dalam history
    public void browse(String url) {
        // Jika kita berada di tengah history, hapus semua yang ada di depan
        if (currentIndex < history.size() - 1) {
            history.subList(currentIndex + 1, history.size()).clear();
        }
        history.add(url);
        currentIndex++;
        System.out.println("Website \"" + url + "\" telah ditambahkan ke history.");
    }

    // Fungsi untuk kembali ke website sebelumnya
    public void back() {
        if (currentIndex <= 0) {
            System.out.println("Tidak ada website sebelumnya.");
            return;
        }
        currentIndex--;
        String previousUrl = history.get(currentIndex);
        history.remove(history.size() - 1); // Hapus history terakhir
        System.out.println("Kembali ke website: " + previousUrl);
    }
}

// Kelas Main untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. View History");
            System.out.println("2. Browse Website");
            System.out.println("3. Back");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");

            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline yang tersisa

            switch (pilihan) {
                case 1:
                    browserHistory.view();
                    break;
                case 2:
                    System.out.print("Masukkan URL website: ");
                    String url = scanner.nextLine();
                    browserHistory.browse(url);
                    break;
                case 3:
                    browserHistory.back();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);

        scanner.close(); // Menutup scanner
    }
}