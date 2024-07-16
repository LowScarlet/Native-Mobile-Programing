/*
  Warnings:

  - You are about to drop the column `telepon` on the `Karyawan` table. All the data in the column will be lost.
  - You are about to drop the column `telepon` on the `Pelanggan` table. All the data in the column will be lost.
  - You are about to drop the column `telepon` on the `Pemasok` table. All the data in the column will be lost.
  - Added the required column `nomorHp` to the `Karyawan` table without a default value. This is not possible if the table is not empty.
  - Added the required column `nomorHp` to the `Pelanggan` table without a default value. This is not possible if the table is not empty.
  - Added the required column `nomorHp` to the `Pemasok` table without a default value. This is not possible if the table is not empty.

*/
-- AlterTable
ALTER TABLE "Karyawan" DROP COLUMN "telepon",
ADD COLUMN     "nomorHp" TEXT NOT NULL;

-- AlterTable
ALTER TABLE "Pelanggan" DROP COLUMN "telepon",
ADD COLUMN     "nomorHp" TEXT NOT NULL;

-- AlterTable
ALTER TABLE "Pemasok" DROP COLUMN "telepon",
ADD COLUMN     "nomorHp" TEXT NOT NULL;
