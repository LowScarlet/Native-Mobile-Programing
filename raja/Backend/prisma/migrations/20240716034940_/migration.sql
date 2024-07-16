-- CreateTable
CREATE TABLE "Pelanggan" (
    "id" SERIAL NOT NULL,
    "nama" TEXT NOT NULL,
    "alamat" TEXT NOT NULL,
    "telepon" TEXT NOT NULL,
    "email" TEXT,

    CONSTRAINT "Pelanggan_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Pemasok" (
    "id" SERIAL NOT NULL,
    "nama" TEXT NOT NULL,
    "alamat" TEXT NOT NULL,
    "telepon" TEXT NOT NULL,
    "email" TEXT,

    CONSTRAINT "Pemasok_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Karyawan" (
    "id" SERIAL NOT NULL,
    "nama" TEXT NOT NULL,
    "alamat" TEXT NOT NULL,
    "telepon" TEXT NOT NULL,
    "email" TEXT,

    CONSTRAINT "Karyawan_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Pemesanan" (
    "id" SERIAL NOT NULL,
    "tanggal" TEXT NOT NULL,
    "pelangganId" INTEGER NOT NULL,
    "galonId" INTEGER NOT NULL,
    "jumlah" INTEGER NOT NULL,
    "status" TEXT NOT NULL,

    CONSTRAINT "Pemesanan_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Pengantaran" (
    "id" SERIAL NOT NULL,
    "tanggal" TEXT NOT NULL,
    "karyawanId" INTEGER NOT NULL,
    "pemesananId" INTEGER NOT NULL,
    "status" TEXT NOT NULL,

    CONSTRAINT "Pengantaran_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Galon" (
    "id" SERIAL NOT NULL,
    "nama" TEXT NOT NULL,
    "harga" DOUBLE PRECISION NOT NULL,
    "stok" INTEGER NOT NULL,
    "pemasokId" INTEGER NOT NULL,

    CONSTRAINT "Galon_pkey" PRIMARY KEY ("id")
);

-- CreateIndex
CREATE UNIQUE INDEX "Pengantaran_pemesananId_key" ON "Pengantaran"("pemesananId");

-- AddForeignKey
ALTER TABLE "Pemesanan" ADD CONSTRAINT "Pemesanan_pelangganId_fkey" FOREIGN KEY ("pelangganId") REFERENCES "Pelanggan"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Pemesanan" ADD CONSTRAINT "Pemesanan_galonId_fkey" FOREIGN KEY ("galonId") REFERENCES "Galon"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Pengantaran" ADD CONSTRAINT "Pengantaran_karyawanId_fkey" FOREIGN KEY ("karyawanId") REFERENCES "Karyawan"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Pengantaran" ADD CONSTRAINT "Pengantaran_pemesananId_fkey" FOREIGN KEY ("pemesananId") REFERENCES "Pemesanan"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

-- AddForeignKey
ALTER TABLE "Galon" ADD CONSTRAINT "Galon_pemasokId_fkey" FOREIGN KEY ("pemasokId") REFERENCES "Pemasok"("id") ON DELETE RESTRICT ON UPDATE CASCADE;
