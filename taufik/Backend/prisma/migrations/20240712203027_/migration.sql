-- CreateTable
CREATE TABLE "Konsumen" (
    "id" SERIAL NOT NULL,
    "nama" TEXT NOT NULL,
    "alamat" TEXT NOT NULL,
    "email" TEXT,
    "nomorHp" TEXT,

    CONSTRAINT "Konsumen_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Meja" (
    "id" SERIAL NOT NULL,
    "nomor" INTEGER NOT NULL,
    "kapasitas" INTEGER NOT NULL,
    "lokasi" TEXT,

    CONSTRAINT "Meja_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Menu" (
    "id" SERIAL NOT NULL,
    "kode" TEXT NOT NULL,
    "nama" TEXT NOT NULL,
    "deskripsi" TEXT,
    "harga" DOUBLE PRECISION NOT NULL,
    "kategori" TEXT,

    CONSTRAINT "Menu_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Pesanan" (
    "id" SERIAL NOT NULL,
    "konsumenId" INTEGER NOT NULL,
    "jumlahTotal" DOUBLE PRECISION NOT NULL,
    "tanggal" TEXT NOT NULL,
    "catatan" TEXT,

    CONSTRAINT "Pesanan_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Reservasi" (
    "id" SERIAL NOT NULL,
    "konsumenId" INTEGER NOT NULL,
    "mejaId" INTEGER NOT NULL,
    "tanggal" TEXT NOT NULL,
    "waktu" TEXT NOT NULL,
    "catatan" TEXT,

    CONSTRAINT "Reservasi_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "ItemPesanan" (
    "id" SERIAL NOT NULL,
    "pesananId" INTEGER NOT NULL,
    "menuId" INTEGER NOT NULL,
    "kuantitas" INTEGER NOT NULL,
    "catatan" TEXT,

    CONSTRAINT "ItemPesanan_pkey" PRIMARY KEY ("id")
);

-- CreateIndex
CREATE UNIQUE INDEX "Meja_nomor_key" ON "Meja"("nomor");

-- CreateIndex
CREATE UNIQUE INDEX "Menu_kode_key" ON "Menu"("kode");

-- AddForeignKey
ALTER TABLE "Pesanan" ADD CONSTRAINT "Pesanan_konsumenId_fkey" FOREIGN KEY ("konsumenId") REFERENCES "Konsumen"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Reservasi" ADD CONSTRAINT "Reservasi_konsumenId_fkey" FOREIGN KEY ("konsumenId") REFERENCES "Konsumen"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Reservasi" ADD CONSTRAINT "Reservasi_mejaId_fkey" FOREIGN KEY ("mejaId") REFERENCES "Meja"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "ItemPesanan" ADD CONSTRAINT "ItemPesanan_pesananId_fkey" FOREIGN KEY ("pesananId") REFERENCES "Pesanan"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "ItemPesanan" ADD CONSTRAINT "ItemPesanan_menuId_fkey" FOREIGN KEY ("menuId") REFERENCES "Menu"("id") ON DELETE RESTRICT ON UPDATE CASCADE;
