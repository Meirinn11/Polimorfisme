class BankBCA extends Bank {
    public BankBCA(int saldoAwal) {
        super(saldoAwal);
    }

    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga dari BCA adalah: 4.5%");
    }

    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        super.transferUang(jumlah, rekeningTujuan, "BCA");
    }
}