import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi saldo awal
        System.out.print("Masukkan saldo awal rekening: ");
        int saldoAwal = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        Bank bank = new Bank(saldoAwal);
        BankBNI bankBNI = new BankBNI(saldoAwal);
        BankBCA bankBCA = new BankBCA(saldoAwal);

        // Menampilkan pesan selamat datang
        System.out.println("======= Selamat Datang =======");
        
        // Input nama rekening
        System.out.print("Nama rekening: ");
        String namaRekening = scanner.nextLine();

        // Input nomor rekening
        System.out.print("Nomor rekening: ");
        String nomorRekening = scanner.nextLine();

        // Menampilkan saldo awal
        System.out.println("Saldo awal rekening: " + bank.getSaldo());

        // Input jumlah uang yang ingin ditransfer
        System.out.print("Masukkan jumlah uang yang ingin ditransfer: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        // Input rekening tujuan
        System.out.print("Masukkan rekening tujuan: ");
        String rekeningTujuan = scanner.nextLine();

        // Input bank tujuan
        System.out.print("Masukkan bank tujuan (BNI/BCA/Bank Lain): ");
        String bankTujuan = scanner.nextLine();

        // Input nomor rekening tujuan
        System.out.print("Masukkan nomor rekening tujuan: ");
        String nomorRekeningTujuan = scanner.nextLine();

        // Menghitung biaya transfer
        double biayaTransfer = bank.hitungBiayaTransfer(bankTujuan);
        int totalPengeluaran = jumlah + (int)biayaTransfer;

        // Melakukan transfer
        if (totalPengeluaran <= bank.getSaldo()) {
            if (bankTujuan.equalsIgnoreCase("BNI")) {
                bankBNI.transferUang(jumlah, rekeningTujuan, bankTujuan);
            } else if (bankTujuan.equalsIgnoreCase("BCA")) {
                bankBCA.transferUang(jumlah, rekeningTujuan, bankTujuan);
            } else {
                bank.transferUang(jumlah, rekeningTujuan, bankTujuan, "");
            }
            // Mengurangi saldo dengan total pengeluaran
            bank.transferUang(totalPengeluaran, rekeningTujuan);
            System.out.println("Biaya transfer: " + biayaTransfer);
            System.out.println("Saldo setelah transfer: " + (saldoAwal - totalPengeluaran));
        } else {
            System.out.println("Saldo tidak cukup untuk melakukan transfer.");
        }

        // Menampilkan suku bunga
        bank.sukuBunga();

        // Menampilkan pesan terima kasih
        System.out.println("======= Terima Kasih =======");

        // Menutup scanner
        scanner.close();
    }
}