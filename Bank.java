import java.util.Scanner;

class Bank {
    private int saldo;

    public Bank(int saldoAwal) {
        this.saldo = saldoAwal;
    }

    // Method untuk transfer uang ke rekening lain
    public void transferUang(int jumlah, String rekeningTujuan) {
        if (jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("Transfer " + jumlah + " ke rekening " + rekeningTujuan);
        } else {
            System.out.println("Saldo tidak cukup untuk transfer.");
        }
    }

    // Method untuk transfer uang ke rekening lain di bank berbeda
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        if (jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("Transfer " + jumlah + " ke rekening " + rekeningTujuan + " di bank " + bankTujuan);
        } else {
            System.out.println("Saldo tidak cukup untuk transfer.");
        }
    }

    // Method untuk transfer uang dengan tambahan berita
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        if (jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("Transfer " + jumlah + " ke rekening " + rekeningTujuan + " di bank " + bankTujuan + " dengan berita: " + berita);
        } else {
            System.out.println("Saldo tidak cukup untuk transfer.");
        }
    }

    // Method untuk mencetak suku bunga standar
    public void sukuBunga() {
        System.out.println("Suku Bunga standar adalah 3%");
    }

    // Method untuk menghitung biaya transfer
    public double hitungBiayaTransfer(String bankTujuan) {
        switch (bankTujuan) {
            case "BNI":
                return 5000; // Biaya transfer ke BNI
            case "BCA":
                return 7000; // Biaya transfer ke BCA
            default:
                return 3000; // Biaya transfer ke bank lain
        }
    }

    // Method untuk mendapatkan saldo saat ini
    public int getSaldo() {
        return saldo;
    }
}

class BankBNI extends Bank {
    public BankBNI(int saldoAwal) {
        super(saldoAwal);
    }

    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga dari BNI adalah: 4%");
    }

    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        super.transferUang(jumlah, rekeningTujuan, "BNI");
    }
}