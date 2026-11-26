package com.example.data.seed

import com.example.data.model.GlossaryTerm
import com.example.data.model.LanguageRule
import com.example.data.model.MateriChapter
import com.example.data.model.QuizQuestion
import com.example.data.model.ReadingCategory
import com.example.data.model.ReadingPassage
import com.example.data.model.StructurePart

object KurikulumKelas10Seed {

    val chapters: List<MateriChapter> = listOf(
        MateriChapter(
            id = "lho",
            orderNumber = 1,
            title = "Teks Laporan Hasil Observasi",
            subtitle = "Mengamati objek secara ilmiah, objektif, dan terstruktur",
            estimatedMinutes = 6,
            summaryEasy = "Bayangkan kamu sedang menjadi peneliti muda. Saat mengamati tanaman di halaman sekolah, kucing jalanan, atau ekosistem sungai, kamu mencatat apa adanya sesuai fakta—tanpa melebih-lebihkan perasaan pribadi. Itulah inti Teks Laporan Hasil Observasi (LHO): menyampaikan fakta hasil pengamatan secara runtut dan objektif.",
            realWorldUse = "Berguna saat menulis laporan praktikum IPA/IPS, liputan jurnalistik sekolah, atau membuat proposal riset siswa.",
            structures = listOf(
                StructurePart(
                    label = "Pernyataan Umum / Klasifikasi",
                    explanation = "Bagian pembuka yang memperkenalkan objek secara umum beserta definisi, nama ilmiah (jika ada), atau pengelompokannya.",
                    sampleExcerpt = "Pohon kelapa (Cocos nucifera) merupakan tumbuhan palma berbatang tunggal yang banyak tumbuh di wilayah pesisir tropis Nusantara."
                ),
                StructurePart(
                    label = "Deskripsi Bagian",
                    explanation = "Menguraikan bagian-bagian objek secara terperinci berdasarkan hasil pengamatan nyata (bentuk, ukuran, warna, fungsi).",
                    sampleExcerpt = "Akar serabutnya menancap kuat hingga kedalaman dua meter. Batangnya beruas tanpa cabang, sedangkan daunnya menyirip sepanjang tiga hingga empat meter."
                ),
                StructurePart(
                    label = "Deskripsi Manfaat / Simpulan",
                    explanation = "Menjelaskan kegunaan, peran ekologis, atau nilai ekonomis objek bagi lingkungan dan kehidupan manusia.",
                    sampleExcerpt = "Hampir seluruh bagian kelapa bermanfaat: airnya menyegarkan tubuh, daging buahnya diolah menjadi santan dan kopra, serta sabutnya menjadi bahan tali ramah lingkungan."
                )
            ),
            languageRules = listOf(
                LanguageRule(
                    title = "Kalimat Definisi",
                    explanation = "Menjelaskan pengertian objek menggunakan kopula seperti adalah, ialah, merupakan, atau yakni.",
                    example = "Terumbu karang adalah ekosistem bawah laut yang dibangun oleh koloni hewan karang."
                ),
                LanguageRule(
                    title = "Kalimat Deskripsi",
                    explanation = "Menggambarkan ciri fisik atau sifat objek yang dapat ditangkap pancaindra secara konkret.",
                    example = "Sisik ikan cupang itu memantulkan warna biru metalik saat terkena sinar matahari."
                ),
                LanguageRule(
                    title = "Frasa Nomina & Verba",
                    explanation = "Menggunakan kelompok kata benda untuk menyebut objek spesifik dan kata kerja aktif untuk menjelaskan perilaku.",
                    example = "Burung jalak bali mencari serangga di sela-sela ranting kering."
                ),
                LanguageRule(
                    title = "Kata Baku & Istilah Ilmiah",
                    explanation = "Memakai kosakata resmi sesuai KBBI dan istilah keilmuan agar laporan tepercaya.",
                    example = "Fotosintesis, habitat, endemik, klasifikasi, ekosistem."
                )
            ),
            practicalTips = listOf(
                "Catat data angka, ukuran, atau warna saat observasi berlangsung agar tulisanmu tidak mengawang.",
                "Hindari kata ganti orang pertama seperti 'saya rasa' atau 'menurutku' karena LHO bersifat objektif.",
                "Gunakan paragraf klasifikasi sebelum masuk ke detail bagian agar pembaca langsung paham konteksnya."
            ),
            commonMistakes = listOf(
                "Menulis: 'Bunga melati itu sangat cantik dan bikin aku tenang.'" to "Perbaikan: 'Bunga melati memiliki kelopak putih berukuran kecil dan mengeluarkan aroma khas pada malam hari.'",
                "Mencampur fakta dengan opini pribadi di bagian Deskripsi Bagian." to "Pastikan setiap kalimat di Deskripsi Bagian bisa dibuktikan lewat pengamatan."
            ),
            quizTopicId = "nonsastra"
        ),
        MateriChapter(
            id = "anekdot",
            orderNumber = 2,
            title = "Teks Anekdot",
            subtitle = "Menyampaikan kritik sosial cerdas melalui cerita lucu yang mengena",
            estimatedMinutes = 5,
            summaryEasy = "Pernah mendengar cerita singkat yang bikin tertawa sekaligus langsung membuatmu berpikir, 'Iya juga ya, sindirannya kena banget!'? Nah, itu Teks Anekdot! Berbeda dengan humor biasa yang hanya bertujuan menghibur, anekdot selalu membawa pesan kritik terhadap layanan publik, kebiasaan buruk, atau fenomena sosial secara halus.",
            realWorldUse = "Cocok untuk menulis kolom satir majalah dinding, naskah stand-up comedy edukatif, atau opini kreatif di media sosial.",
            structures = listOf(
                StructurePart(
                    label = "Abstraksi",
                    explanation = "Gambaran awal singkat tentang suasana atau latar kejadian sebelum cerita bergulir.",
                    sampleExcerpt = "Pagi itu ruang tunggu layanan warga penuh sesak oleh antrean yang mengular sejak pukul tujuh."
                ),
                StructurePart(
                    label = "Orientasi",
                    explanation = "Pengenalan tokoh dan situasi awal yang memicu peristiwa dalam cerita.",
                    sampleExcerpt = "Pak Budi memegang nomor antrean 048 sambil melirik loket yang baru melayani nomor 003."
                ),
                StructurePart(
                    label = "Krisis",
                    explanation = "Puncak kejanggalan, masalah, atau sindiran tajam yang menjadi inti kelucuan sekaligus kritik.",
                    sampleExcerpt = "Ketika Pak Budi bertanya mengapa berkasnya butuh sepuluh tanda tangan, petugas menjawab santai, 'Supaya tinta pulpen kantor tidak cepat kering, Pak.'"
                ),
                StructurePart(
                    label = "Reaksi",
                    explanation = "Tanggapan tokoh lain terhadap peristiwa aneh atau sindiran pada bagian krisis.",
                    sampleExcerpt = "Seluruh warga di ruang tunggu serempak menahan tawa sambil menepuk kening mendengar jawaban tersebut."
                ),
                StructurePart(
                    label = "Koda",
                    explanation = "Penutup cerita yang menegaskan kesan akhir, perubahan sikap, atau renungan singkat.",
                    sampleExcerpt = "Sejak siang itu, loket tersebut akhirnya memasang alur pengurusan satu pintu yang jauh lebih ringkas."
                )
            ),
            languageRules = listOf(
                LanguageRule(
                    title = "Kalimat Retoris",
                    explanation = "Kalimat tanya yang tidak membutuhkan jawaban karena jawabannya sudah tersirat untuk menyindir.",
                    example = "Apakah menunggu tiga jam hanya untuk selembar stempel itu tanda pelayanan prima?"
                ),
                LanguageRule(
                    title = "Majas Sindiran (Ironi & Sinisme)",
                    explanation = "Menggunakan ungkapan berkebalikan dari kenyataan agar kritik terasa elegan dan tidak kasar.",
                    example = "Wah, hebat sekali, jalan berlubang di depan sekolah ini sudah bisa dipakai budidaya lele!"
                ),
                LanguageRule(
                    title = "Konjungsi Temporal",
                    explanation = "Kata hubung penanda urutan waktu seperti kemudian, lalu, setelah itu, sejak saat itu.",
                    example = "Setelah menunggu dua jam, barulah papan pengumuman berbunyi."
                )
            ),
            practicalTips = listOf(
                "Pilih isu sehari-hari yang dekat dengan pelajar (misalnya sampah di kelas, antrean kantin, atau kecanduan gawai).",
                "Sampaikan kritik lewat dialog tak terduga, bukan lewat ceramah panjang.",
                "Pastikan tetap santun dan tidak menyerang fisik atau SARA."
            ),
            commonMistakes = listOf(
                "Cerita lucu tanpa kritik atau pesan sosial." to "Tambahkan bagian krisis yang menyoroti perilaku atau sistem yang perlu diperbaiki.",
                "Sindiran berubah menjadi makian kasar." to "Gunakan ironi atau perumpamaan halus agar pembaca tersenyum lalu merenung."
            ),
            quizTopicId = "sastra"
        ),
        MateriChapter(
            id = "hikayat",
            orderNumber = 3,
            title = "Hikayat (Sastra Klasik)",
            subtitle = "Menyelami kearifan Melayu klasik dan mengadaptasinya ke masa kini",
            estimatedMinutes = 7,
            summaryEasy = "Hikayat adalah cerita prosa lama Nusantara yang diwariskan turun-temurun sebagai hiburan sekaligus teladan moral. Walaupun diwarnai istana, kesaktian, atau kata-kata arkais seperti 'hatta' dan 'syahdan', nilai di dalamnya—kejujuran, kecerdikan, dan bakti—masih sangat relevan untuk kita terapkan hari ini.",
            realWorldUse = "Melatih kepekaan budaya Nusantara, memperkaya kosakata sastra, dan melatih keterampilan mengubah cerita klasik menjadi cerpen modern.",
            structures = listOf(
                StructurePart(
                    label = "Karakteristik Istana Sentris",
                    explanation = "Berlatar lingkungan kerajaan dengan tokoh raja, permaisuri, hulubalang, atau pangeran.",
                    sampleExcerpt = "Syahdan, tersebutlah perkataan seorang raja di negeri Antah Berantah yang sangat adil lagi bijaksana."
                ),
                StructurePart(
                    label = "Kemustahilan & Kesaktian",
                    explanation = "Terdapat kejadian di luar logika modern untuk menegaskan keagungan atau ujian tokoh.",
                    sampleExcerpt = "Bayi itu keluar dari dalam buluh betung sambil memegang sebilah keris emas."
                ),
                StructurePart(
                    label = "Nilai Moral & Didaktis",
                    explanation = "Amanat tersurat maupun tersirat tentang kebijaksanaan, kejujuran, dan kesetiaan.",
                    sampleExcerpt = "Barang siapa menjaga amanah ketika diuji kesulitan, niscaya kelak ia menuai kemuliaan."
                )
            ),
            languageRules = listOf(
                LanguageRule(
                    title = "Kata Arkais (Klasik)",
                    explanation = "Kosakata Melayu lama yang jarang dipakai dalam percakapan masa kini.",
                    example = "Hatta (lalu), syahdan (selanjutnya), titah (perintah raja), mahligai (istana), beroleh (mendapat)."
                ),
                LanguageRule(
                    title = "Konjungsi Urutan Peristiwa",
                    explanation = "Penggunaan kata penghubung khas hikayat seperti maka, lalu, adapun, alkisah.",
                    example = "Alkisah, pada suatu petang berjalanlah Si Miskin menyusuri pinggir hutan."
                ),
                LanguageRule(
                    title = "Majas & Bahasa Kias",
                    explanation = "Penggunaan perumpamaan alam untuk menggambarkan watak dan emosi.",
                    example = "Wajahnya berseri bagai purnama empat belas hari."
                )
            ),
            practicalTips = listOf(
                "Saat membaca hikayat, tandai kata arkais lalu cek padanannya di glosarium atau KBBI.",
                "Untuk mengubah hikayat menjadi cerpen modern, pertahankan alur dan nilai moralnya, lalu ganti latar dan bahasanya menjadi Indonesia populer."
            ),
            commonMistakes = listOf(
                "Menganggap hikayat sulit dipahami hanya karena kata-kata klasiknya." to "Pahami konteks kalimat secara utuh dan gunakan glosarium kata arkais.",
                "Menyamakan cerita fantasi modern dengan hikayat." to "Hikayat bersifat anonim, lisan/klasik, dan kental dengan nilai budaya Melayu."
            ),
            quizTopicId = "sastra"
        ),
        MateriChapter(
            id = "negosiasi",
            orderNumber = 4,
            title = "Teks Negosiasi",
            subtitle = "Seni berdialog dan tawar-menawar demi kesepakatan saling menguntungkan",
            estimatedMinutes = 5,
            summaryEasy = "Setiap hari sebenarnya kita bernegosiasi: menawar harga buku di pasar loak, berdiskusi jadwal piket dengan teman, atau mengajukan izin kegiatan OSIS ke kepala sekolah. Teks Negosiasi mengajarkan cara menyampaikan alasan dengan santun dan logis sehingga kedua belah pihak mencapai titik temu (win-win solution).",
            realWorldUse = "Praktis dipakai saat rapat OSIS, jual beli UMKM, diskusi kelompok, hingga wawancara beasiswa atau kerja.",
            structures = listOf(
                StructurePart(
                    label = "Orientasi",
                    explanation = "Pembuka percakapan berupa salam, sapaan hangat, dan penyampaian maksud awal.",
                    sampleExcerpt = "Selamat pagi, Bu. Kami dari panitia bulan bahasa bermaksud meminjam aula sekolah untuk lomba baca puisi."
                ),
                StructurePart(
                    label = "Pengajuan",
                    explanation = "Penyampaian keinginan atau tawaran pertama disertai alasan yang masuk akal.",
                    sampleExcerpt = "Kami berencana menggunakan aula hari Sabtu penuh dari pukul 08.00 hingga 15.00 WIB."
                ),
                StructurePart(
                    label = "Penawaran",
                    explanation = "Proses tawar-menawar dan saling memberi alternatif solusi apabila ada kendala.",
                    sampleExcerpt = "Sabtu pagi aula dipakai latihan paduan suara sampai pukul 10.00. Bagaimana jika lomba dimulai pukul 10.30 hingga 16.00?"
                ),
                StructurePart(
                    label = "Persetujuan",
                    explanation = "Titik temu yang disepakati bersama tanpa ada pihak yang merasa dirugikan.",
                    sampleExcerpt = "Baik, Bu, kami setuju mulai pukul 10.30. Kami juga bertanggung jawab merapikan kursi setelah acara selesai."
                )
            ),
            languageRules = listOf(
                LanguageRule(
                    title = "Bahasa Persuasif & Santun",
                    explanation = "Menggunakan pilihan kata yang menghargai lawan bicara, tidak memaksa, dan berbasis solusi.",
                    example = "Bagaimana jika kita atur ulang jadwalnya agar kedua kegiatan tetap berjalan lancar?"
                ),
                LanguageRule(
                    title = "Kalimat Bersyarat / Kompromi",
                    explanation = "Memakai kata 'jika', 'apabila', atau 'dengan syarat' untuk menawarkan jalan tengah.",
                    example = "Saya bersedia menurunkan harga menjadi Rp45.000 apabila pembelian minimal tiga buah."
                ),
                LanguageRule(
                    title = "Pasangan Tuturan",
                    explanation = "Dialog berbalas secara wajar: meminta-memenuhi, menawarkan-menerima/menolak.",
                    example = "Penjual menawarkan opsi paket; pembeli menanggapi dengan pertimbangan anggaran."
                )
            ),
            practicalTips = listOf(
                "Dengarkan alasan lawan bicara sebelum langsung menolak.",
                "Siapkan dua atau tiga alternatif kompromi sebelum bernegosiasi.",
                "Akhiri kesepakatan dengan menegaskan ulang poin yang disetujui agar tidak terjadi salah paham."
            ),
            commonMistakes = listOf(
                "Menggunakan nada memaksa atau mengancam saat menawar." to "Ganti tekanan emosional dengan alasan logis dan sikap saling menghormati.",
                "Negosiasi berakhir tanpa kejelasan keputusan." to "Selalu tutup dengan kalimat persetujuan yang konkret."
            ),
            quizTopicId = "nonsastra"
        ),
        MateriChapter(
            id = "biografi",
            orderNumber = 5,
            title = "Teks Biografi",
            subtitle = "Meneladani perjuangan dan karakter unggul tokoh inspiratif",
            estimatedMinutes = 6,
            summaryEasy = "Teks Biografi bukan sekadar daftar tanggal lahir dan jabatan seseorang, melainkan kisah nyata perjuangan seorang tokoh menghadapi rintangan hingga memberi dampak bagi masyarakat. Dengan membaca dan menulis biografi, kita belajar memetik keteladanan karakter yang dapat menginspirasi langkah hidup kita.",
            realWorldUse = "Membantu menyusun profil tokoh inspiratif, esai refleksi diri, atau artikel profil alumni berprestasi di sekolah.",
            structures = listOf(
                StructurePart(
                    label = "Orientasi",
                    explanation = "Mengenalkan identitas tokoh, latar belakang keluarga, masa kecil, dan konteks zaman.",
                    sampleExcerpt = "Mohammad Hatta lahir di Bukittinggi pada 12 Agustus 1902 dan tumbuh dalam lingkungan keluarga yang menjunjung tinggi pendidikan serta kejujuran."
                ),
                StructurePart(
                    label = "Kejadian / Peristiwa Penting",
                    explanation = "Rangkaian peristiwa krusial, tantangan, kegagalan, serta keputusan berani yang membentuk prestasi tokoh.",
                    sampleExcerpt = "Meski sempat diasingkan ke Boven Digoel, Bung Hatta tidak berhenti membaca dan menulis artikel pendidikan bagi rakyat."
                ),
                StructurePart(
                    label = "Reorientasi",
                    explanation = "Pandangan penulis mengenai keteladanan atau warisan nilai tokoh bagi pembaca masa kini.",
                    sampleExcerpt = "Kedisiplinan dan integritas Hatta menjadi pengingat bahwa kecerdasan sejati selalu berpihak pada kepentingan umum."
                )
            ),
            languageRules = listOf(
                LanguageRule(
                    title = "Kata Ganti Orang Ketiga",
                    explanation = "Menggunakan ia, dia, beliau, atau nama tokoh secara konsisten.",
                    example = "Beliau tetap menuliskan gagasannya walau akses buku saat itu sangat terbatas."
                ),
                LanguageRule(
                    title = "Kata Kerja Tindakan (Verba Material)",
                    explanation = "Menunjukkan aksi nyata yang dilakukan tokoh.",
                    example = "Mendirikan, merintis, menulis, menempuh, memperjuangkan."
                ),
                LanguageRule(
                    title = "Kata Sifat (Adjektiva)",
                    explanation = "Menggambarkan karakter unggul tokoh berdasarkan bukti perbuatan.",
                    example = "Tekun, bersahaja, visioner, gigih, peduli."
                )
            ),
            practicalTips = listOf(
                "Jangan hanya menyalin tahun-tahun penting; ceritakan konflik dan cara tokoh bangkit dari kegagalan.",
                "Tunjukkan sifat tokoh lewat tindakan nyata, bukan sekadar menyebut 'ia sangat baik'."
            ),
            commonMistakes = listOf(
                "Tertukar antara biografi (ditulis orang lain) dengan autobiografi (ditulis tokoh sendiri)." to "Gunakan sudut pandang orang ketiga (ia/beliau) untuk biografi.",
                "Mengarang fakta tanpa sumber tepercaya." to "Selalu verifikasi tahun, tempat, dan peristiwa dari referensi kredibel."
            ),
            quizTopicId = "nonsastra"
        ),
        MateriChapter(
            id = "puisi",
            orderNumber = 6,
            title = "Puisi & Apresiasi Sastra",
            subtitle = "Menangkap rasa, diksi, imaji, dan makna tersirat dalam bait puisi",
            estimatedMinutes = 6,
            summaryEasy = "Puisi adalah seni memadatkan pengalaman, perasaan, dan gagasan paling dalam ke dalam kata-kata yang hemat namun bertenaga. Di Kelas 10, kita tidak perlu takut salah mengartikan puisi—kunci utamanya adalah peka terhadap pilihan kata (diksi), bayangan indra (imaji), dan suasana hati penyair.",
            realWorldUse = "Mengasah kepekaan bahasa, memperkaya diksi saat berpidato atau menulis esai, serta mengekspresikan gagasan secara artistik.",
            structures = listOf(
                StructurePart(
                    label = "Diksi & Kata Konkret",
                    explanation = "Pemilihan kata yang cermat dan tepat guna membangkitkan emosi serta bayangan nyata di benak pembaca.",
                    sampleExcerpt = "Di beranda senja, bayang pohon ketapang memanjang seperti rindu yang enggan pulang."
                ),
                StructurePart(
                    label = "Pengimajian (Citraan)",
                    explanation = "Susunan kata yang membuat pembaca seolah melihat, mendengar, atau merasakan langsung suasana puisi.",
                    sampleExcerpt = "Gemersik halaman buku beradu dengan rintik hujan di kaca jendela (citraan dengar & lihat)."
                ),
                StructurePart(
                    label = "Majas & Tipografi",
                    explanation = "Penggunaan gaya bahasa kiasan dan tata letak baris/bait untuk memperkuat makna dan irama.",
                    sampleExcerpt = "Lampu-lampu kota berjaga hingga fajar, menyimak langkah para pelajar yang belum lelah bermimpi (personifikasi)."
                )
            ),
            languageRules = listOf(
                LanguageRule(
                    title = "Makna Denotatif vs Konotatif",
                    explanation = "Denotatif adalah arti kamus sebenarnya; konotatif adalah arti kiasan yang memuat nilai rasa.",
                    example = "'Akar' secara denotatif berarti bagian tumbuhan; secara konotatif bisa berarti asal-usul atau dasar pemikiran."
                ),
                LanguageRule(
                    title = "Citraan Pancaindra",
                    explanation = "Citraan penglihatan (visual), pendengaran (auditif), dan perabaan/perasaan (taktil).",
                    example = "'Dingin embun menyapa telapak kaki' memakai citraan perabaan sekaligus personifikasi."
                ),
                LanguageRule(
                    title = "Rima & Irama",
                    explanation = "Pengulangan bunyi dan pergantian tinggi-rendah tekanan saat puisi dideklamasikan.",
                    example = "Pengulangan vokal dan konsonan di akhir larik menciptakan musikalitas alami."
                )
            ),
            practicalTips = listOf(
                "Bacalah puisi dengan bersuara pelan minimal dua kali untuk menangkap iramanya.",
                "Tentukan suasana dulu (haru, gelisah, optimis, atau syahdu) sebelum menyimpulkan amanat.",
                "Saat menulis puisi sendiri, ganti kata umum seperti 'sedih' dengan benda konkret, misalnya 'cangkir teh yang telanjur dingin'."
            ),
            commonMistakes = listOf(
                "Mengira puisi selalu harus berima a-b-a-b." to "Puisi modern bebas berima, yang terpenting adalah kekuatan diksi, imaji, dan kesatuan makna.",
                "Membaca puisi terlalu cepat seperti membaca berita." to "Beri jeda pada tanda baca dan pergantian bait agar maknanya meresap."
            ),
            quizTopicId = "sastra"
        )
    )

    val readings: List<ReadingPassage> = listOf(
        // SASTRA 1
        ReadingPassage(
            id = "sastra_surat_halaman",
            title = "Surat dari Halaman Sekolah",
            subtitle = "Antologi Puisi Pelajar & Bedah Diksi",
            authorOrSource = "Sastra Modern • Karya Edukatif Lentera Kata",
            category = ReadingCategory.SASTRA,
            subGenre = "Puisi Modern",
            readingMinutes = 3,
            coverKey = "sastra",
            paragraphs = listOf(
                "Di bangku kayu yang mulai retak catnya,\nkita mengeja pagi sebelum bel berbunyi,\ntinta biru menari di atas kertas bergaris,\nmenyimpan tanya yang belum selesai kita jawab kemarin.",
                "Ada buku-buku tua di rak paling atas,\nyang punggungnya letih oleh waktu,\nnamun di balik lembarnya yang menguning,\nseribu kota menyala tanpa pernah padam.",
                "Jika kelak langkah kita berpencar di persimpangan,\nbawalah seberkas cahaya dari ruang baca ini,\nsebab kata yang kau rawat hari ini,\nakan menjadi kompas saat jalan terasa berkabut."
            ),
            glossary = listOf(
                GlossaryTerm("mengeja", "verba", "Membaca huruf demi huruf atau memahami sesuatu secara perlahan.", "Kita mengeja pagi sebelum bel berbunyi."),
                GlossaryTerm("seberkas", "nomina", "Seikat atau sekelompok kecil cahaya atau barang.", "Bawalah seberkas cahaya dari ruang baca ini."),
                GlossaryTerm("kompas", "nomina (kiasan)", "Penunjuk arah; dalam puisi bermakna pedoman hidup dan berpikir.", "Kata yang kau rawat akan menjadi kompas.")
            ),
            teacherReflection = "Perhatikan bagaimana penyair tidak langsung menulis 'belajarlah rajin-rajin'. Ia memakai citraan konkret seperti 'bangku kayu', 'lembar menguning', dan metafora 'seribu kota menyala' untuk menggambarkan betapa luasnya dunia pengetahuan di dalam buku.",
            questions = listOf(
                QuizQuestion(
                    id = "q_puisi_1",
                    topicId = "sastra",
                    question = "Apa makna kiasan dari larik 'seribu kota menyala tanpa pernah padam' pada bait kedua?",
                    options = listOf(
                        "Listrik di perpustakaan sekolah selalu menyala sepanjang malam",
                        "Buku menyimpan pengetahuan dan kisah dunia yang terus hidup melampaui waktu",
                        "Banyak siswa belajar di perkotaan besar hingga larut malam",
                        "Rak buku di kelas berada dekat lampu penerangan"
                    ),
                    correctIndex = 1,
                    explanation = "Metafora 'seribu kota menyala' melambangkan kekayaan gagasan, pengetahuan, dan imajinasi yang tersimpan abadi di dalam buku."
                ),
                QuizQuestion(
                    id = "q_puisi_2",
                    topicId = "sastra",
                    question = "Majas yang dominan pada larik 'tinta biru menari di atas kertas bergaris' adalah...",
                    options = listOf("Personifikasi", "Hiperbola", "Litotes", "Ironi"),
                    correctIndex = 0,
                    explanation = "Personifikasi memberi sifat manusia ('menari') kepada benda mati ('tinta biru')."
                ),
                QuizQuestion(
                    id = "q_puisi_3",
                    topicId = "sastra",
                    question = "Suasana utama yang dibangun dalam puisi tersebut adalah...",
                    options = listOf("Marah dan penuh protes", "Reflektif, hangat, dan optimistis", "Takut dan tertekan", "Lucu dan menyindir"),
                    correctIndex = 1,
                    explanation = "Bait-baitnya mengajak pembaca merenung dengan hangat tentang kenangan belajar dan harapan masa depan."
                )
            )
        ),
        // SASTRA 2
        ReadingPassage(
            id = "sastra_hikayat_bayan",
            title = "Hikayat Burung Bayan yang Bijaksana",
            subtitle = "Kisah Klasik tentang Kecerdikan & Menjaga Amanah",
            authorOrSource = "Adaptasi Sastra Melayu Klasik",
            category = ReadingCategory.SASTRA,
            subGenre = "Hikayat",
            readingMinutes = 5,
            coverKey = "sastra",
            paragraphs = listOf(
                "Alkisah, pada zaman dahulu di sebuah negeri yang makmur, hiduplah seorang saudagar bernama Khojan Maimun bersama istrinya, Bibi Zainab. Sebelum pergi berlayar mencari nafkah ke negeri jauh, sang saudagar berpesan agar istrinya selalu bermusyawarah dengan seekor burung bayan yang cerdik sebelum mengambil keputusan penting.",
                "Syahdan, sepeninggal suaminya, Bibi Zainab merasa kesepian dan nyaris tergoda untuk meninggalkan rumah tanpa izin demi menemui seorang pangeran yang melintas di depan mahligai. Melihat hal itu, burung bayan tidak memarahi ataupun melarangnya secara kasar, karena ia tahu hati yang sedang goyah justru akan membangkang jika dicegah dengan amarah.",
                "Hatta, dengan suara lembut burung bayan berkata, 'Duhai Tuan Puteri, sebelum Tuan melangkah keluar, izinkan hamba berkisah tentang seekor tiung yang setia menjaga kehormatan tuannya.' Karena penasaran, Bibi Zainab pun duduk menyimak hingga larut malam. Setiap malam berikutnya, burung bayan selalu menyajikan kisah baru penuh hikmah tentang kesetiaan, kesabaran, dan akibat ketergesa-gesaan.",
                "Demikianlah kecerdikan burung bayan menunda langkah keliru Bibi Zainab malam demi malam hingga Khojan Maimun pulang dengan selamat. Bibi Zainab akhirnya sadar dan berterima kasih kepada burung bayan karena kesabarannya telah menyelamatkan keutuhan rumah tangga mereka."
            ),
            glossary = listOf(
                GlossaryTerm("alkisah", "konjungsi arkais", "Kata pembuka cerita klasik yang berarti 'ceritanya' atau 'tersebutlah kisah'.", "Alkisah, pada zaman dahulu hiduplah seorang saudagar."),
                GlossaryTerm("syahdan", "partikel arkais", "Selanjutnya; lalu (digunakan untuk berpindah ke peristiwa berikutnya).", "Syahdan, sepeninggal suaminya, Bibi Zainab merasa kesepian."),
                GlossaryTerm("mahligai", "nomina", "Istana atau bangunan tempat tinggal raja/bangsawan yang megah.", "Pangeran itu melintas di depan mahligai."),
                GlossaryTerm("hatta", "konjungsi arkais", "Lalu; kemudian; maka.", "Hatta, dengan suara lembut burung bayan berkata.")
            ),
            teacherReflection = "Mengapa kisah ini hebat? Burung bayan tidak menasihati dengan amarah atau paksaan, melainkan memakai kekuatan cerita (literasi bercerita) untuk menyentuh kesadaran pendengarnya. Ini bukti bahwa bahasa yang santun dan cerdas sering kali lebih kuat daripada bentakan.",
            questions = listOf(
                QuizQuestion(
                    id = "q_hikayat_1",
                    topicId = "sastra",
                    question = "Mengapa burung bayan memilih bercerita alih-alih langsung memarahi Bibi Zainab?",
                    options = listOf(
                        "Karena burung bayan takut dimarahi pangeran",
                        "Karena menasihati orang yang hatinya goyah lebih efektif lewat cerita bijak daripada paksaan",
                        "Karena Khojan Maimun melarang burung bayan berbicara keras",
                        "Karena burung bayan ingin pamer kemampuan menghafal dongeng"
                    ),
                    correctIndex = 1,
                    explanation = "Dalam teks dijelaskan bahwa burung bayan tahu hati yang sedang goyah akan membangkang jika dicegah dengan amarah."
                ),
                QuizQuestion(
                    id = "q_hikayat_2",
                    topicId = "sastra",
                    question = "Nilai moral utama yang dapat dipetik pelajar dari hikayat di atas adalah...",
                    options = listOf(
                        "Pentingnya mengumpulkan harta sebanyak mungkin dengan berlayar",
                        "Menjaga amanah, kesetiaan, dan berpikir tenang sebelum bertindak",
                        "Larangan berteman dengan orang dari luar negeri",
                        "Keunggulan hewan peliharaan dibandingkan manusia"
                    ),
                    correctIndex = 1,
                    explanation = "Amanah utama hikayat ini adalah menjaga kepercayaan, berpikir jernih, dan menasihati dengan cara bijaksana."
                ),
                QuizQuestion(
                    id = "q_hikayat_3",
                    topicId = "sastra",
                    question = "Arti kata arkais 'hatta' dalam hikayat tersebut adalah...",
                    options = listOf("Meskipun demikian", "Lalu atau kemudian", "Pada akhirnya", "Tidak pernah"),
                    correctIndex = 1,
                    explanation = "Dalam kosakata Melayu klasik, 'hatta' berfungsi sebagai kata sambung waktu yang berarti 'lalu' atau 'kemudian'."
                )
            )
        ),
        // SASTRA 3
        ReadingPassage(
            id = "sastra_cerpen_sepatu",
            title = "Sepasang Sepatu di Rak Perpustakaan",
            subtitle = "Cerpen Remaja tentang Empati & Kebiasaan Membaca",
            authorOrSource = "Cerpen Kontemporer • Koleksi Lentera Kata",
            category = ReadingCategory.SASTRA,
            subGenre = "Cerpen",
            readingMinutes = 4,
            coverKey = "sastra",
            paragraphs = listOf(
                "Setiap jam istirahat kedua, ketika sebagian besar siswa kelas X menyerbu kantin demi semangkuk bakso hangat, Raka justru menyelinap ke pojok utara perpustakaan. Di sana, dekat rak sastra lama, ia selalu melepas sepatunya yang sol kanannya sedikit menganga dan menyembunyikannya rapi di bawah meja baca.",
                "Bukan karena Raka malu. Ia hanya tidak ingin suara sol sepatunya yang berdecit mengganggu Pak Darmawan, pustakawan berkacamata tebal yang sedang menata kartu katalog. Selama dua bulan terakhir, Raka menamatkan lima buku—dari novel sejarah Nusantara hingga kumpulan esai sains populer—sambil menyantap bekal singkong rebus yang dibungkus daun pisang.",
                "Suatu siang yang terik, Raka mendapati selembar catatan kecil terselip di dalam buku biografi yang sedang ia pinjam. Tulisannya rapi: 'Buku yang bagus selalu menemukan pembaca yang tekun. Di meja depan, ada sepasang sepatu ukuran 41 bekas hadiah lomba yang tidak terpakai. Pakai saja jika nyaman—dari pembaca yang pernah duduk di pojok utara.'",
                "Raka menoleh ke meja petugas. Pak Darmawan tampak sibuk memunggungi ruangan sambil menyeduh teh, tetapi ujung bibirnya melengkung tipis. Sore itu, Raka pulang tidak hanya membawa tas berisi dua buku pinjaman baru, melainkan juga keyakinan bahwa kebaikan di sekolah sering tumbuh paling sunyi di tempat orang-orang tekun membaca."
            ),
            glossary = listOf(
                GlossaryTerm("menganga", "verba", "Terbuka lebar (dalam cerpen menggambarkan bagian sol sepatu yang terlepas).", "Sol kanannya sedikit menganga."),
                GlossaryTerm("katalog", "nomina", "Daftar berisi judul buku, pengarang, dan nomor rak untuk memudahkan pencarian di perpustakaan.", "Menata kartu katalog."),
                GlossaryTerm("tekun", "adjektiva", "Rajin, keras hati, dan bersungguh-sungguh dalam melakukan sesuatu.", "Buku yang bagus menemukan pembaca yang tekun.")
            ),
            teacherReflection = "Cerpen yang kuat tidak selalu butuh peristiwa besar atau konflik dramatis. Detail kecil seperti sol sepatu yang berdecit dan catatan di dalam buku justru membuat tokoh terasa hidup dan menanamkan nilai empati tanpa menggurui.",
            questions = listOf(
                QuizQuestion(
                    id = "q_cerpen_1",
                    topicId = "sastra",
                    question = "Mengapa Raka selalu melepas sepatunya saat berada di pojok perpustakaan?",
                    options = listOf(
                        "Karena aturan perpustakaan mewajibkan semua siswa melepas sepatu",
                        "Agar suara sol sepatunya yang rusak tidak mengganggu ketenangan pustakawan",
                        "Karena sepatunya basah terkena hujan di halaman sekolah",
                        "Agar ia bisa berlari lebih cepat ketika bel masuk berbunyi"
                    ),
                    correctIndex = 1,
                    explanation = "Teks menyebutkan Raka tidak ingin suara sol sepatunya yang berdecit mengganggu Pak Darmawan."
                ),
                QuizQuestion(
                    id = "q_cerpen_2",
                    topicId = "sastra",
                    question = "Bagaimana watak Pak Darmawan digambarkan pada akhir cerita?",
                    options = listOf(
                        "Tegas dan mudah marah kepada siswa",
                        "Peduli dan tulus membantu tanpa ingin dipuji",
                        "Ceroboh karena sering meninggalkan barang",
                        "Acuh tak acuh terhadap pengunjung perpustakaan"
                    ),
                    correctIndex = 1,
                    explanation = "Pak Darmawan membantu Raka secara diam-diam lewat catatan dan sepatu di meja depan tanpa mencari pujian."
                ),
                QuizQuestion(
                    id = "q_cerpen_3",
                    topicId = "sastra",
                    question = "Sudut pandang yang digunakan pengarang dalam cerpen tersebut adalah...",
                    options = listOf(
                        "Orang pertama pelaku utama ('aku')",
                        "Orang ketiga serbatahu/pengamat ('Raka', 'ia')",
                        "Orang kedua ('kamu')",
                        "Campuran orang pertama dan kedua"
                    ),
                    correctIndex = 1,
                    explanation = "Pengarang menyebut nama tokoh ('Raka') dan kata ganti 'ia', yang merupakan ciri sudut pandang orang ketiga."
                )
            )
        ),

        // NON-SASTRA 1
        ReadingPassage(
            id = "nonsastra_mangrove",
            title = "Ekosistem Mangrove Pesisir Utara Jawa",
            subtitle = "Contoh Teks Laporan Hasil Observasi (LHO) Terstruktur",
            authorOrSource = "Non-Sastra • Modul Observasi Lingkungan",
            category = ReadingCategory.NON_SASTRA,
            subGenre = "Laporan Observasi",
            readingMinutes = 4,
            coverKey = "nonsastra",
            paragraphs = listOf(
                "Hutan mangrove adalah ekosistem hutan pantai yang tumbuh di wilayah pasang surut air laut dan muara sungai berlumpur. Di pesisir utara Jawa, jenis mangrove yang paling banyak dijumpai ialah bakau (Rhizophora mucronata) dan api-api (Avicennia marina). Tumbuhan ini memiliki kemampuan unik menyaring kadar garam tinggi sehingga mampu bertahan hidup di lingkungan pesisir yang ekstrem.",
                "Secara fisik, tanaman bakau mudah dikenali melalui akar tunjangnya yang melengkung dan menjulang keluar dari lumpur. Akar tersebut berfungsi menopang batang dari terjangan ombak sekaligus menyerap oksigen saat air pasang naik. Daunnya tebal berlapis lilin dengan warna hijau tua mengilap untuk mengurangi penguapan, sedangkan buahnya berbentuk silinder memanjang yang siap berkecambah begitu jatuh ke lumpur.",
                "Di sela-sela akar mangrove, hidup beragam biota laut seperti kepiting bakau, ikan gelodok, udang kecil, serta kerang. Ekosistem ini berperan sebagai daerah asuhan (nursery ground) alami bagi benih ikan sebelum berenang menuju laut lepas.",
                "Selain menjaga keanekaragaman hayati, hutan mangrove memberi manfaat besar bagi masyarakat pesisir. Sabuk hijau mangrove mampu meredam energi gelombang pasang, mencegah abrasi pantai, dan menyerap karbon dioksida lebih efektif dibandingkan hutan daratan. Apabila dikelola secara berkelanjutan, kawasan mangrove juga menjadi sarana edukasi ekologi bagi pelajar."
            ),
            glossary = listOf(
                GlossaryTerm("abrasi", "nomina", "Pengikisan pantai oleh tenaga gelombang laut dan arus laut yang bersifat merusak.", "Mencegah abrasi pantai."),
                GlossaryTerm("biota", "nomina", "Keseluruhan flora dan fauna yang terdapat di dalam suatu daerah atau ekosistem.", "Hidup beragam biota laut."),
                GlossaryTerm("pasang surut", "nomina", "Gerakan naik turunnya permukaan air laut secara berkala akibat gaya tarik bulan dan matahari.", "Wilayah pasang surut air laut.")
            ),
            teacherReflection = "Amati struktur teks ini! Paragraf 1 = Pernyataan Umum (definisi mangrove), Paragraf 2–3 = Deskripsi Bagian (ciri akar, daun, buah, serta biota di sekitarnya), Paragraf 4 = Deskripsi Manfaat. Tidak ada opini 'menurut saya', semuanya fakta hasil pengamatan!",
            questions = listOf(
                QuizQuestion(
                    id = "q_lho_1",
                    topicId = "nonsastra",
                    question = "Paragraf pertama dalam bacaan tersebut termasuk bagian struktur LHO yang disebut...",
                    options = listOf("Deskripsi Manfaat", "Pernyataan Umum / Klasifikasi", "Orientasi", "Reorientasi"),
                    correctIndex = 1,
                    explanation = "Paragraf pertama berisi definisi umum hutan mangrove dan jenis-jenisnya, sehingga merupakan Pernyataan Umum."
                ),
                QuizQuestion(
                    id = "q_lho_2",
                    topicId = "nonsastra",
                    question = "Apa fungsi lapisan lilin pada daun bakau berdasarkan paragraf kedua?",
                    options = listOf(
                        "Menarik perhatian kepiting bakau",
                        "Mengurangi penguapan di lingkungan pesisir yang panas",
                        "Menghasilkan suara saat terkena angin laut",
                        "Menyimpan air hujan untuk musim kemarau"
                    ),
                    correctIndex = 1,
                    explanation = "Paragraf kedua menyatakan secara eksplisit bahwa daun tebal berlapis lilin berfungsi mengurangi penguapan."
                ),
                QuizQuestion(
                    id = "q_lho_3",
                    topicId = "nonsastra",
                    question = "Kalimat manakah yang merupakan kalimat definisi?",
                    options = listOf(
                        "Daunnya tebal berlapis lilin dengan warna hijau tua mengilap.",
                        "Hutan mangrove adalah ekosistem hutan pantai yang tumbuh di wilayah pasang surut.",
                        "Di sela-sela akar mangrove hidup beragam biota laut.",
                        "Kawasan mangrove juga menjadi sarana edukasi ekologi."
                    ),
                    correctIndex = 1,
                    explanation = "Kalimat definisi ditandai kata kopula 'adalah' untuk menjelaskan pengertian objek."
                )
            )
        ),
        // NON-SASTRA 2
        ReadingPassage(
            id = "nonsastra_kartini",
            title = "R.A. Kartini dan Kekuatan Kata Tertulis",
            subtitle = "Teks Biografi Tokoh • Mengubah Zaman Lewat Literasi",
            authorOrSource = "Non-Sastra • Profil Tokoh Nasional",
            category = ReadingCategory.NON_SASTRA,
            subGenre = "Biografi",
            readingMinutes = 4,
            coverKey = "nonsastra",
            paragraphs = listOf(
                "Raden Adjeng Kartini lahir di Jepara, Jawa Tengah, pada 21 April 1879. Sejak belia, ia dikenal gemar membaca surat kabar, majalah ilmu pengetahuan, dan buku-buku sastra berbahasa Belanda milik kakaknya, Sosrokartono. Kebiasaan membaca itu membuka cakrawala berpikirnya melampaui dinding kabupaten tempat ia tinggal.",
                "Ketika memasuki usia remaja, adat pingitan memaksa Kartini berhenti bersekolah dan tinggal di dalam rumah. Alih-alih menyerah pada kejenuhan, ia menjadikan pena dan kertas sebagai jendela dunia. Kartini rutin menulis surat kepada sahabat-sahabat penanya di Eropa, menguraikan gagasannya mengenai kesetaraan akses pendidikan bagi perempuan pribumi serta pentingnya memajukan kecerdasan bangsa.",
                "Tidak berhenti pada wacana, Kartini bersama adik-adiknya mendirikan sekolah kecil di serambi rumah untuk mengajari anak-anak perempuan setempat membaca, menulis, berhitung, dan keterampilan membatik. Setelah wafat pada usia muda tahun 1904, kumpulan suratnya diterbitkan dalam buku 'Habis Gelap Terbitlah Terang' yang menginspirasi berdirinya Sekolah Kartini di berbagai kota.",
                "Kisah Kartini membuktikan kepada pelajar masa kini bahwa keterbatasan ruang gerak tidak mampu membatasi pikiran yang terbiasa membaca dan menulis. Gagasan yang dirangkai secara jujur, bernas, dan santun sanggup menembus batas zaman."
            ),
            glossary = listOf(
                GlossaryTerm("pingitan", "nomina", "Adat masa lampau yang melarang gadis remaja keluar rumah sebelum menikah.", "Adat pingitan memaksa Kartini berhenti bersekolah."),
                GlossaryTerm("cakrawala", "nomina (kiasan)", "Batas pandang atau luasnya wawasan dan pengetahuan seseorang.", "Membuka cakrawala berpikirnya."),
                GlossaryTerm("bernas", "adjektiva", "Berisi penuh; dalam konteks tulisan berarti padat gagasan dan meyakinkan.", "Gagasan yang dirangkai secara jujur dan bernas.")
            ),
            teacherReflection = "Sebagai pelajar Kelas 10, perhatikan bagaimana kata kerja tindakan ('membaca', 'menulis', 'mendirikan') membuktikan karakter Kartini jauh lebih kuat daripada sekadar pujian kosong. Itulah teknik emas menulis teks biografi!",
            questions = listOf(
                QuizQuestion(
                    id = "q_bio_1",
                    topicId = "nonsastra",
                    question = "Apa hal yang dilakukan Kartini saat menghadapi masa pingitan?",
                    options = listOf(
                        "Berhenti belajar dan memilih berdagang kain batik",
                        "Terus membaca buku dan menyalurkan gagasan pendidikan melalui surat-menyurat",
                        "Pindah ke luar negeri bersama kakaknya",
                        "Menutup akses komunikasi dengan dunia luar"
                    ),
                    correctIndex = 1,
                    explanation = "Kartini menjadikan pena dan kertas sebagai jendela dunia dengan membaca dan menulis surat kepada sahabat penanya."
                ),
                QuizQuestion(
                    id = "q_bio_2",
                    topicId = "nonsastra",
                    question = "Paragraf terakhir dalam teks biografi Kartini berfungsi sebagai...",
                    options = listOf("Orientasi", "Kejadian Penting", "Reorientasi", "Abstraksi"),
                    correctIndex = 2,
                    explanation = "Paragraf penutup berisi pandangan/penilaian penulis tentang keteladanan tokoh bagi pembaca masa kini (Reorientasi)."
                ),
                QuizQuestion(
                    id = "q_bio_3",
                    topicId = "nonsastra",
                    question = "Sinonim kata 'bernas' pada paragraf penutup yang paling tepat adalah...",
                    options = listOf("Kosong dan panjang", "Padat dan berisi", "Samar dan ragu", "Cepat dan singkat"),
                    correctIndex = 1,
                    explanation = "Dalam KBBI, 'bernas' berarti penuh atau berisi (tentang gagasan/pidato/tulisan)."
                )
            )
        ),
        // NON-SASTRA 3
        ReadingPassage(
            id = "nonsastra_membaca_mendalam",
            title = "Membaca Mendalam di Era Gulir Cepat",
            subtitle = "Artikel Opini Literasi untuk Pelajar SMA",
            authorOrSource = "Non-Sastra • Esai Pendidikan",
            category = ReadingCategory.NON_SASTRA,
            subGenre = "Artikel Opini",
            readingMinutes = 4,
            coverKey = "nonsastra",
            paragraphs = listOf(
                "Setiap hari, jari kita mungkin menggulir ratusan unggahan singkat di layar ponsel dalam hitungan menit. Kita merasa sudah membaca banyak hal—judul berita, potongan kutipan, hingga komentar warganet. Namun, pernahkah kita merasa cepat lupa pada isi berita yang baru lima menit lalu kita lihat?",
                "Fenomena tersebut terjadi karena otak kita terbiasa melakukan pembacaan memindai (skimming) secara tergesa-gesa. Sebaliknya, membaca mendalam (deep reading) membutuhkan jeda: kita menelusuri argumen penulis, membandingkan bukti, serta merenungkan maknanya. Kebiasaan membaca mendalam melatih daya fokus dan kemampuan berpikir kritis yang sangat dibutuhkan di jenjang SMA.",
                "Kabar baiknya, kita tidak harus langsung menamatkan buku tebal dalam semalam untuk melatih kebiasaan ini. Mulailah dengan membaca satu artikel utuh atau dua halaman cerpen setiap hari tanpa membuka tab lain selama sepuluh menit. Catat satu kata baru dan satu gagasan utama yang menurutmu paling menarik.",
                "Literasi bukan soal seberapa cepat mata kita melompati baris kalimat, melainkan seberapa dalam pikiran kita berdialog dengan bacaan. Ketika kita terbiasa membaca utuh, kita tidak mudah terpancing judul sensasional dan lebih siap menyusun argumen kita sendiri secara jernih."
            ),
            glossary = listOf(
                GlossaryTerm("argumen", "nomina", "Alasan atau bukti logis yang dipakai untuk memperkuat atau menolak suatu pendapat.", "Menelusuri argumen penulis."),
                GlossaryTerm("sensasional", "adjektiva", "Bersifat merangsang emosi atau menghebohkan, sering kali melebih-lebihkan fakta.", "Tidak mudah terpancing judul sensasional."),
                GlossaryTerm("literasi", "nomina", "Kemampuan memahami, mengevaluasi, dan menggunakan informasi tertulis secara kritis.", "Literasi bukan soal seberapa cepat mata melompat.")
            ),
            teacherReflection = "Teks opini yang bagus selalu punya: (1) masalah yang dekat dengan pembaca, (2) alasan logis berbasis mekanisme nyata, dan (3) solusi praktis yang bisa langsung dilakukan. Coba terapkan teknik 10 menit tanpa distraksi ini mulai malam ini!",
            questions = listOf(
                QuizQuestion(
                    id = "q_opini_1",
                    topicId = "nonsastra",
                    question = "Mengapa pembaca sering cepat lupa terhadap unggahan singkat yang baru digulir di media sosial?",
                    options = listOf(
                        "Karena ukuran huruf di ponsel terlalu kecil",
                        "Karena otak hanya melakukan pemindaian cepat (skimming) tanpa jeda memahami argumen",
                        "Karena semua unggahan di internet bersifat fiksi",
                        "Karena memori manusia tidak mampu menyimpan teks digital"
                    ),
                    correctIndex = 1,
                    explanation = "Penulis menjelaskan bahwa pembacaan memindai secara tergesa membuat informasi lewat begitu saja tanpa pemrosesan mendalam."
                ),
                QuizQuestion(
                    id = "q_opini_2",
                    topicId = "nonsastra",
                    question = "Langkah konkret apa yang disarankan penulis untuk mulai melatih membaca mendalam?",
                    options = listOf(
                        "Membeli sepuluh novel sekaligus",
                        "Menghapus seluruh aplikasi di ponsel",
                        "Membaca satu artikel utuh atau dua halaman cerpen selama sepuluh menit tanpa distraksi",
                        "Menghafal kamus dari halaman pertama"
                    ),
                    correctIndex = 2,
                    explanation = "Paragraf ketiga menyarankan langkah bertahap: sepuluh menit fokus membaca satu artikel utuh atau dua halaman cerpen."
                ),
                QuizQuestion(
                    id = "q_opini_3",
                    topicId = "nonsastra",
                    question = "Apa tujuan utama penulis menulis artikel opini tersebut?",
                    options = listOf(
                        "Melarang pelajar menggunakan ponsel pintar",
                        "Mengajak pelajar beralih dari sekadar memindai cepat menuju membaca mendalam agar berpikir kritis",
                        "Mempromosikan toko buku tertentu",
                        "Menjelaskan sejarah ditemukannya mesin cetak"
                    ),
                    correctIndex = 1,
                    explanation = "Artikel ini bersifat persuasif edukatif agar pelajar melatih kebiasaan deep reading."
                )
            )
        ),

        // PENGETAHUAN UMUM 1
        ReadingPassage(
            id = "umum_sejarah_bahasa",
            title = "Jejak Bahasa Indonesia: Dari Melayu Pasar ke Bahasa Dunia",
            subtitle = "Pengetahuan Umum • Sejarah & Kebanggaan Berbahasa",
            authorOrSource = "Pengetahuan Umum • Sejarah Kebahasaan Nusantara",
            category = ReadingCategory.PENGETAHUAN_UMUM,
            subGenre = "Sejarah & Budaya",
            readingMinutes = 4,
            coverKey = "pengetahuan",
            paragraphs = listOf(
                "Tahukah kamu mengapa Bahasa Melayu dipilih menjadi cikal bakal Bahasa Indonesia, padahal jumlah penutur bahasa daerah lain seperti Bahasa Jawa kala itu jauh lebih banyak? Jawabannya terletak pada sifat Bahasa Melayu yang demokratis, tidak mengenal tingkatan bahasa yang kaku, dan telah berfungsi sebagai bahasa perhubungan (lingua franca) antarpedagang di pelabuhan Nusantara selama berabad-abad.",
                "Tonggak persatuan itu dikukuhkan pada 28 Oktober 1928 melalui butir ketiga Sumpah Pemuda: 'Kami putra dan putri Indonesia menjunjung bahasa persatuan, bahasa Indonesia.' Para pemuda dari beragam suku secara sukarela memilih satu bahasa pemersatu agar gagasan kemerdekaan dapat dipahami dari Sabang sampai Merauke.",
                "Setelah merdeka, Bahasa Indonesia terus berkembang dinamis. Kosakatanya diperkaya dari bahasa-bahasa daerah di Nusantara—seperti kata 'nyeri' (Sunda), 'ampuh' (Jawa), dan 'pantau' (Minangkabau)—serta serapan bahasa asing yang disesuaikan dengan kaidah ejaan nasional.",
                "Puncaknya, pada November 2023, Konferensi Umum UNESCO secara resmi menetapkan Bahasa Indonesia sebagai salah satu bahasa resmi dalam Sidang Umum UNESCO. Kini Bahasa Indonesia dipelajari di puluhan negara dan menjadi jembatan budaya Nusantara di kancah internasional."
            ),
            glossary = listOf(
                GlossaryTerm("lingua franca", "frasa nomina", "Bahasa pergaulan atau bahasa pengantar yang dipakai oleh penutur yang berbeda-beda bahasa ibunya.", "Berfungsi sebagai lingua franca antarpedagang."),
                GlossaryTerm("cikal bakal", "frasa nomina", "Permulaan atau asal mula terjadinya sesuatu.", "Menjadi cikal bakal Bahasa Indonesia."),
                GlossaryTerm("dinamis", "adjektiva", "Penuh semangat dan terus bergerak atau berkembang mengikuti zaman.", "Bahasa Indonesia terus berkembang dinamis.")
            ),
            teacherReflection = "Belajar Bahasa Indonesia bukan sekadar menghafal aturan ejaan untuk ujian, melainkan merawat warisan pemersatu bangsa yang kini diakui dunia. Setiap kali kamu memakai Bahasa Indonesia yang baik dan santun, kamu ikut menjaga martabat bahasa ini!",
            questions = listOf(
                QuizQuestion(
                    id = "q_sejarah_1",
                    topicId = "pengetahuan_umum",
                    question = "Mengapa Bahasa Melayu dipilih sebagai dasar Bahasa Indonesia meskipun bukan bahasa dengan penutur terbanyak pada masa itu?",
                    options = listOf(
                        "Karena dipaksakan oleh pemerintah kolonial",
                        "Karena sifatnya demokratis dan sudah menjadi bahasa perhubungan antarpedagang Nusantara",
                        "Karena tidak memiliki kosakata serapan sama sekali",
                        "Karena hanya digunakan oleh kalangan bangsawan kerajaan"
                    ),
                    correctIndex = 1,
                    explanation = "Bahasa Melayu telah menjadi lingua franca pelabuhan Nusantara dan tidak memiliki tingkatan kasta bahasa yang rumit."
                ),
                QuizQuestion(
                    id = "q_sejarah_2",
                    topicId = "pengetahuan_umum",
                    question = "Peristiwa bersejarah apa yang mengukuhkan Bahasa Indonesia sebagai bahasa persatuan pada 28 Oktober 1928?",
                    options = listOf(
                        "Sidang Umum UNESCO",
                        "Kongres Pemuda II (Sumpah Pemuda)",
                        "Proklamasi Kemerdekaan",
                        "Kongres Bahasa Indonesia X"
                    ),
                    correctIndex = 1,
                    explanation = "Butir ketiga Sumpah Pemuda pada 28 Oktober 1928 mengikrarkan Bahasa Indonesia sebagai bahasa persatuan."
                ),
                QuizQuestion(
                    id = "q_sejarah_3",
                    topicId = "pengetahuan_umum",
                    question = "Apa bukti pengakuan internasional terhadap Bahasa Indonesia pada November 2023?",
                    options = listOf(
                        "Ditetapkan sebagai bahasa resmi Sidang Umum UNESCO",
                        "Menggantikan seluruh bahasa daerah di Asia Tenggara",
                        "Menjadi satu-satunya bahasa pengantar penerbangan dunia",
                        "Menghapus penggunaan kata serapan asing dalam KBBI"
                    ),
                    correctIndex = 0,
                    explanation = "Pada November 2023, UNESCO menetapkan Bahasa Indonesia sebagai salah satu bahasa resmi Sidang Umum UNESCO."
                )
            )
        ),
        // PENGETAHUAN UMUM 2
        ReadingPassage(
            id = "umum_cek_fakta",
            title = "Saring Sebelum Sharing: Jurus Cek Fakta Pelajar",
            subtitle = "Pengetahuan Umum • Literasi Informasi & Anti-Hoaks",
            authorOrSource = "Pengetahuan Umum • Panduan Literasi Digital",
            category = ReadingCategory.PENGETAHUAN_UMUM,
            subGenre = "Literasi Digital",
            readingMinutes = 4,
            coverKey = "pengetahuan",
            paragraphs = listOf(
                "Setiap kali berita sensasional muncul di grup obrolan, dorongan pertama banyak orang adalah segera meneruskannya agar terlihat paling cepat tahu. Padahal, kecepatan menyebar tidak pernah menjamin kebenaran informasi. Dalam literasi informasi modern, pelajar perlu membedakan tiga hal: fakta (dapat diverifikasi), opini (pendapat pribadi), dan disinformasi (rekayasa menyesatkan).",
                "Para pemeriksa fakta di seluruh dunia sering menggunakan metode SIFT yang mudah diingat. Pertama, Stop (berhenti sejenak): jangan langsung klik tombol bagikan jika sebuah kabar memancing amarah atau kepanikan berlebihan. Emosi yang meledak sering menjadi tanda berita rekayasa.",
                "Kedua, Investigate the source (selidiki sumbernya): siapa penulis atau lembaga di balik situs tersebut? Media tepercaya selalu mencantumkan susunan redaksi, alamat jelas, dan standar koreksi berita. Ketiga, Find better coverage (cari pembanding): ketik kata kunci berita di mesin pencari untuk melihat apakah minimal dua media kredibel lain melaporkannya.",
                "Keempat, Trace claims to the original context (telusuri konteks asli): foto peristiwa tahun 2016 sering kali diunggah ulang dengan keterangan seolah terjadi hari ini. Dengan kebiasaan cek silang selama satu menit, kita melindungi diri sendiri, keluarga, dan teman sekolah dari jebakan hoaks."
            ),
            glossary = listOf(
                GlossaryTerm("verifikasi", "nomina", "Pemeriksaan tentang kebenaran laporan, pernyataan, atau perhitungan.", "Fakta dapat diverifikasi."),
                GlossaryTerm("disinformasi", "nomina", "Informasi salah yang sengaja dibuat dan disebarkan untuk menipu orang lain.", "Membedakan fakta, opini, dan disinformasi."),
                GlossaryTerm("kredibel", "adjektiva", "Dapat dipercaya dan dipertanggungjawabkan kebenarannya.", "Minimal dua media kredibel lain.")
            ),
            teacherReflection = "Pelajaran Bahasa Indonesia mengajarkan kita memahami makna tersurat dan tersirat. Jurus SIFT ini adalah penerapan langsung keterampilan membaca kritis di dunia nyata!",
            questions = listOf(
                QuizQuestion(
                    id = "q_sift_1",
                    topicId = "pengetahuan_umum",
                    question = "Apa langkah pertama ('Stop') dalam metode cek fakta SIFT?",
                    options = listOf(
                        "Langsung berkomentar di kolom unggahan",
                        "Berhenti sejenak dan tidak langsung membagikan berita yang memancing emosi berlebihan",
                        "Menghapus akun media sosial penulis berita",
                        "Mengirimkan pesan berantai kepada teman sekelas"
                    ),
                    correctIndex = 1,
                    explanation = "Langkah 'Stop' mengajak pembaca menahan diri saat melihat judul yang memancing kepanikan atau kemarahan."
                ),
                QuizQuestion(
                    id = "q_sift_2",
                    topicId = "pengetahuan_umum",
                    question = "Manakah perbedaan tepat antara fakta dan opini?",
                    options = listOf(
                        "Fakta memakai kata sifat subjektif, sedangkan opini berisi angka",
                        "Fakta dapat diverifikasi kebenarannya, sedangkan opini merupakan penilaian pribadi",
                        "Opini selalu benar, sedangkan fakta sering berubah",
                        "Fakta hanya ada di buku IPA, sedangkan opini hanya di koran"
                    ),
                    correctIndex = 1,
                    explanation = "Fakta objektif dan bisa dibuktikan/diverifikasi; opini merupakan sudut pandang atau penilaian pribadi."
                ),
                QuizQuestion(
                    id = "q_sift_3",
                    topicId = "pengetahuan_umum",
                    question = "Mengapa langkah 'Trace claims to the original context' penting dilakukan?",
                    options = listOf(
                        "Untuk mengetahui harga kamera yang dipakai fotografer",
                        "Karena foto atau video lama sering diunggah ulang dengan narasi seolah baru terjadi",
                        "Agar jumlah pengikut media sosial kita meningkat",
                        "Untuk menyalin seluruh berita tanpa mencantumkan sumber"
                    ),
                    correctIndex = 1,
                    explanation = "Banyak hoaks memanfaatkan dokumentasi peristiwa lama dengan konteks waktu/tempat yang dipelintir."
                )
            )
        ),
        // PENGETAHUAN UMUM 3
        ReadingPassage(
            id = "umum_subak_bali",
            title = "Subak Bali: Kearifan Pengairan dan Gotong Royong",
            subtitle = "Pengetahuan Umum • Warisan Budaya Dunia UNESCO",
            authorOrSource = "Pengetahuan Umum • Wawasan Nusantara",
            category = ReadingCategory.PENGETAHUAN_UMUM,
            subGenre = "Budaya & Ekologi",
            readingMinutes = 4,
            coverKey = "pengetahuan",
            paragraphs = listOf(
                "Di lereng-lereng hijau Pulau Bali, sawah bertingkat atau terasering bukan sekadar pemandangan memukau bagi wisatawan. Di balik hamparan padi yang subur itu bekerja sistem pengairan tradisional bernama Subak, yang telah bertahan lebih dari seribu tahun sejak abad ke-11 dan diakui UNESCO sebagai Warisan Budaya Dunia sejak 2012.",
                "Subak pada hakikatnya bukan hanya jaringan kanal dan bendungan bambu atau batu, melainkan organisasi sosial petani yang mengatur pembagian air secara adil dan demokratis. Setiap petani, baik yang sawahnya berada di hulu maupun di hilir, memperoleh jatah air sesuai luas lahan dan jadwal tanam yang disepakati bersama dalam musyawarah.",
                "Sistem ini berakar pada filosofi Tri Hita Karana—tiga sumber keharmonisan hidup: hubungan harmonis antara manusia dengan Tuhan, manusia dengan sesama, serta manusia dengan alam lingkungan. Melalui pengaturan masa tanam serempak, hama tikus dan serangga dapat ditekan secara alami tanpa bergantung sepenuhnya pada bahan kimia.",
                "Dari Subak, generasi muda Indonesia belajar bahwa teknologi terbaik tidak selalu berbentuk mesin rumit. Kerja sama yang jujur, menghormati alam, dan tata kelola adil terbukti mampu menjaga ketahanan pangan lintas generasi."
            ),
            glossary = listOf(
                GlossaryTerm("terasering", "nomina", "Sistem pertanian bertingkat di lahan miring untuk mencegah erosi dan menahan air.", "Sawah bertingkat atau terasering."),
                GlossaryTerm("hulu", "nomina", "Bagian atas sungai atau sumber aliran air (lawan kata dari hilir).", "Sawah yang berada di hulu maupun di hilir."),
                GlossaryTerm("ketahanan pangan", "frasa nomina", "Kondisi terpenuhinya kebutuhan pangan yang cukup, aman, dan berkelanjutan bagi masyarakat.", "Mampu menjaga ketahanan pangan.")
            ),
            teacherReflection = "Bacaan pengetahuan umum seperti ini sangat bagus dijadikan bahan teks LHO atau esai argumentasi di sekolah. Perhatikan kosakata baku seperti 'hakikat', 'filosofi', dan 'demokratis' yang dipakai secara tepat!",
            questions = listOf(
                QuizQuestion(
                    id = "q_subak_1",
                    topicId = "pengetahuan_umum",
                    question = "Apa inti dari sistem Subak menurut bacaan di atas?",
                    options = listOf(
                        "Sekadar saluran irigasi beton modern di Bali",
                        "Organisasi sosial petani dan sistem irigasi tradisional yang membagi air secara adil",
                        "Perlombaan menanam padi di kawasan wisata",
                        "Perusahaan pengelola pupuk organik nasional"
                    ),
                    correctIndex = 1,
                    explanation = "Bacaan menegaskan Subak adalah organisasi sosial petani yang mengatur pembagian air secara adil dan demokratis."
                ),
                QuizQuestion(
                    id = "q_subak_2",
                    topicId = "pengetahuan_umum",
                    question = "Manfaat ekologis dari pengaturan jadwal tanam serempak dalam sistem Subak adalah...",
                    options = listOf(
                        "Menghentikan turunnya hujan di daerah pegunungan",
                        "Menekan perkembangan hama secara alami tanpa bergantung penuh pada bahan kimia",
                        "Menghilangkan kebutuhan air pada tanaman padi",
                        "Mengubah sawah terasering menjadi lahan datar"
                    ),
                    correctIndex = 1,
                    explanation = "Paragraf ketiga menyatakan masa tanam serempak membantu menekan hama tikus dan serangga secara alami."
                ),
                QuizQuestion(
                    id = "q_subak_3",
                    topicId = "pengetahuan_umum",
                    question = "Tiga pilar keharmonisan dalam filosofi Tri Hita Karana meliputi hubungan manusia dengan...",
                    options = listOf(
                        "Teknologi, ekonomi, dan pariwisata",
                        "Tuhan, sesama manusia, dan alam lingkungan",
                        "Pemerintah, pedagang, dan wisatawan",
                        "Masa lalu, masa kini, dan masa depan"
                    ),
                    correctIndex = 1,
                    explanation = "Tri Hita Karana berarti keharmonisan manusia dengan Tuhan, sesama manusia, dan alam."
                )
            )
        )
    )
}
