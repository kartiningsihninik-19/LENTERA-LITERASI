package com.example.data.seed

import com.example.data.model.BuilderField
import com.example.data.model.EffectiveSentenceCase
import com.example.data.model.EydRuleItem
import com.example.data.model.MajasItem
import com.example.data.model.QuizQuestion
import com.example.data.model.QuizTopic
import com.example.data.model.TextBuilderTemplate

object PraktikDanKuisSeed {

    val effectiveSentenceCases: List<EffectiveSentenceCase> = listOf(
        EffectiveSentenceCase(
            id = "eff_1",
            title = "Hindari Pleonasme (Pemborosan Kata)",
            wrongSentence = "Para siswa-siswi kelas X diharapkan agar supaya segera masuk ke dalam ruang perpustakaan.",
            options = listOf(
                "Siswa kelas X diharapkan segera masuk ke ruang perpustakaan.",
                "Para siswa-siswi kelas X diharapkan supaya masuk ke ruang perpustakaan.",
                "Semua siswa-siswi diharapkan agar supaya masuk ruang perpustakaan."
            ),
            correctOptionIndex = 0,
            issueType = "Kehematan Kalimat",
            teacherNote = "Kata 'para' sudah bermakna jamak sehingga tidak perlu digabung dengan 'siswa-siswi'. Kata 'agar' dan 'supaya' juga bermakna sama, cukup pilih satu atau gunakan langsung verba 'segera masuk'."
        ),
        EffectiveSentenceCase(
            id = "eff_2",
            title = "Kata Depan 'di' vs Imbuhan 'di-'",
            wrongSentence = "Buku catatan literasi saya tertinggal dirumah dan baru di temukan ibu pagi tadi.",
            options = listOf(
                "Buku catatan literasi saya tertinggal di rumah dan baru ditemukan ibu pagi tadi.",
                "Buku catatan literasi saya tertinggal dirumah dan baru ditemukan ibu pagi tadi.",
                "Buku catatan literasi saya tertinggal di rumah dan baru di temukan ibu pagi tadi."
            ),
            correctOptionIndex = 0,
            issueType = "Penulisan EYD V",
            teacherNote = "'di' sebagai penunjuk tempat ('di rumah', 'di sekolah') ditulis TERPISAH. Sedangkan 'di-' sebagai awalan kata kerja pasif ('ditemukan', 'dibaca') ditulis SERANGKAI."
        ),
        EffectiveSentenceCase(
            id = "eff_3",
            title = "Subjek Jelas Tanpa Kata Depan di Awal",
            wrongSentence = "Bagi seluruh peserta lomba baca puisi harap berkumpul di aula sekolah pukul 08.00.",
            options = listOf(
                "Seluruh peserta lomba baca puisi harap berkumpul di aula sekolah pukul 08.00.",
                "Untuk seluruh peserta lomba baca puisi agar supaya berkumpul di aula.",
                "Bagi para peserta-peserta lomba baca puisi berkumpul di aula pukul 08.00."
            ),
            correctOptionIndex = 0,
            issueType = "Kelengkapan Subjek",
            teacherNote = "Meletakkan kata depan 'bagi' atau 'untuk' sebelum subjek membuat kalimat kehilangan subjek intinya. Hilangkan kata 'bagi' agar 'Seluruh peserta...' menjadi subjek yang sah."
        ),
        EffectiveSentenceCase(
            id = "eff_4",
            title = "Pemakaian Kata Baku Sesuai KBBI",
            wrongSentence = "Kita harus menganalisa resiko sebelum mengambil ijin mendirikan stand bazar literasi.",
            options = listOf(
                "Kita harus menganalisis risiko sebelum mengambil izin mendirikan stan bazar literasi.",
                "Kita harus menganalisa risiko sebelum mengambil izin mendirikan stand bazar literasi.",
                "Kita harus menganalisis resiko sebelum mengambil ijin mendirikan stan bazar literasi."
            ),
            correctOptionIndex = 0,
            issueType = "Kata Baku KBBI",
            teacherNote = "Bentuk baku menurut KBBI adalah 'analisis' (menganalisis), 'risiko' (bukan resiko), 'izin' (bukan ijin), dan 'stan' (bukan stand)."
        ),
        EffectiveSentenceCase(
            id = "eff_5",
            title = "Kelogisan & Kecermatan Makna",
            wrongSentence = "Waktu dan tempat kami persilakan kepada Ibu Kepala Sekolah untuk memberi sambutan.",
            options = listOf(
                "Kepada Ibu Kepala Sekolah, kami persilakan menyampaikan sambutan.",
                "Waktu dan tempat dipersilakan untuk Ibu Kepala Sekolah.",
                "Untuk waktu dan tempatnya kami persilakan Ibu Kepala Sekolah."
            ),
            correctOptionIndex = 0,
            issueType = "Kelogisan Kalimat",
            teacherNote = "'Waktu dan tempat' adalah benda/konsep abstrak yang tidak bisa berjalan naik ke podium! Yang dipersilakan adalah orangnya (Ibu Kepala Sekolah)."
        ),
        EffectiveSentenceCase(
            id = "eff_6",
            title = "Penulisan 'sekadar', 'kreativitas', dan 'apotek'",
            wrongSentence = "Sekedar informasi, lomba kreatipitas menulis cerpen dibuka di sebelah apotik kota.",
            options = listOf(
                "Sekadar informasi, lomba kreativitas menulis cerpen dibuka di sebelah apotek kota.",
                "Sekedar informasi, lomba kreativitas menulis cerpen dibuka di sebelah apotik kota.",
                "Sekadar informasi, lomba kreatifitas menulis cerpen dibuka di sebelah apotek kota."
            ),
            correctOptionIndex = 0,
            issueType = "Kata Baku KBBI",
            teacherNote = "Ingat tiga kata yang paling sering salah tulis: yang baku adalah 'sekadar' (bukan sekedar), 'kreativitas' (bukan kreatifitas), dan 'apotek' (bukan apotik)."
        )
    )

    val majasList: List<MajasItem> = listOf(
        MajasItem(
            id = "metafora",
            name = "Metafora",
            group = "Majas Perbandingan",
            definition = "Membandingkan dua hal secara langsung tanpa kata penghubung (seperti, bagai) karena memiliki kesamaan sifat.",
            literaryExample = "Buku adalah jendela dunia yang membuka cakrawala pelajar.",
            everydayExample = "Raka menjadi bintang kelas karena selalu membantu teman memahami materi."
        ),
        MajasItem(
            id = "personifikasi",
            name = "Personifikasi",
            group = "Majas Perbandingan",
            definition = "Mengumpamakan benda mati atau alam seolah-olah memiliki sifat, perasaan, atau tindakan manusia.",
            literaryExample = "Angin senja berbisik lembut di antara dedaunan ketapang.",
            everydayExample = "Ponselku menjerit minta diisi daya sejak jam istirahat pertama."
        ),
        MajasItem(
            id = "simile",
            name = "Simile (Asosiasi)",
            group = "Majas Perbandingan",
            definition = "Membandingkan dua hal secara eksplisit dengan kata pembanding: bagai, laksana, seperti, bak, umpama.",
            literaryExample = "Semangatnya menyala laksana obor di tengah malam gulita.",
            everydayExample = "Suasana kelas langsung hening seperti perpustakaan saat guru pengawas masuk."
        ),
        MajasItem(
            id = "hiperbola",
            name = "Hiperbola",
            group = "Majas Pertentangan / Penegasan",
            definition = "Ungkapan yang melebih-lebihkan kenyataan untuk memberi penekanan emosi yang kuat.",
            literaryExample = "Air matanya mengalir menganak sungai melepas kepergian sahabatnya.",
            everydayExample = "Aku sudah menunggu balasan pesanmu sampai berabad-abad lamanya."
        ),
        MajasItem(
            id = "ironi",
            name = "Ironi",
            group = "Majas Sindiran",
            definition = "Menyindir dengan menyatakan hal yang berlawanan dari kenyataan sebenarnya secara halus.",
            literaryExample = "Rapi sekali kamarmu, sampai-sampai buku pelajaran berenang di antara bantal.",
            everydayExample = "Wah, rajin sekali kamu datang tepat waktu... lima menit sebelum bel pulang!"
        ),
        MajasItem(
            id = "sinisme",
            name = "Sinisme",
            group = "Majas Sindiran",
            definition = "Sindiran yang lebih langsung dan tajam daripada ironi, mengungkapkan ketidaksukaan secara lugas.",
            literaryExample = "Percuma membeli rak buku mahal kalau isinya hanya dipajang tanpa pernah dibaca.",
            everydayExample = "Untuk apa membuat jadwal piket kalau ruang kelas tetap berdebu setiap hari?"
        ),
        MajasItem(
            id = "litotes",
            name = "Litotes",
            group = "Majas Pertentangan",
            definition = "Merendahkan diri atau mengecilkan fakta dengan tujuan menjaga kesantunan.",
            literaryExample = "Singgahlah sejenak ke gubuk kami yang sederhana ini.",
            everydayExample = "Ini hanya tulisan kecil hasil belajar semalam, semoga bermanfaat untuk kelompok kita."
        ),
        MajasItem(
            id = "paradoks",
            name = "Paradoks",
            group = "Majas Pertentangan",
            definition = "Menyajikan dua hal yang tampak bertentangan dalam satu kalimat, tetapi keduanya mengandung kebenaran.",
            literaryExample = "Ia merasa kesepian di tengah riuh gemerlap kota metropolitan.",
            everydayExample = "Semakin banyak kita membaca, semakin kita sadar betapa sedikit yang kita ketahui."
        )
    )

    val eydRules: List<EydRuleItem> = listOf(
        EydRuleItem(
            id = "eyd_1",
            title = "Pemakaian Kata Depan 'di' dan 'ke'",
            explanation = "Kata depan 'di', 'ke', dan 'dari' yang menunjukkan tempat atau arah ditulis terpisah dari kata yang mengikutinya.",
            wrongExample = "dibandung, kesekolah, darijakarta",
            rightExample = "di Bandung, ke sekolah, dari Jakarta"
        ),
        EydRuleItem(
            id = "eyd_2",
            title = "Partikel '-pun' yang Ditulis Terpisah vs Serangkai",
            explanation = "'pun' ditulis terpisah (bermakna 'juga'), kecuali pada 12 kata hubung baku seperti meskipun, walaupun, ataupun, maupun, bagaimanapun.",
            wrongExample = "Apa pun masalahnya, ia tetap hadir. (Salah jika ditulis: apapun)",
            rightExample = "Apa pun masalahnya, walaupun hujan turun, ia tetap hadir."
        ),
        EydRuleItem(
            id = "eyd_3",
            title = "Tanda Koma Sebelum Kata Penghubung Intrakalimat",
            explanation = "Gunakan tanda koma sebelum kata 'tetapi', 'melainkan', dan 'sedangkan'. Tidak perlu koma sebelum 'karena' atau 'dan' (kecuali perincian 3+ unsur).",
            wrongExample = "Saya ingin ikut lomba tetapi jadwalnya bentrok.",
            rightExample = "Saya ingin ikut lomba, tetapi jadwalnya bentrok."
        ),
        EydRuleItem(
            id = "eyd_4",
            title = "Penulisan Gelar & Sapaan Kekerabatan",
            explanation = "Huruf pertama kata kekerabatan (Ibu, Bapak, Kakak, Saudara) ditulis kapital jika dipakai sebagai sapaan atau acuan langsung.",
            wrongExample = "Selamat pagi, bu. Bagaimana kabar adik ibu?",
            rightExample = "Selamat pagi, Bu. Silakan duduk, Bapak."
        ),
        EydRuleItem(
            id = "eyd_5",
            title = "Penulisan Unsur Serapan Baku",
            explanation = "Gunakan bentuk baku sesuai EYD V & KBBI, bukan ejaan tidak baku yang sering muncul di percakapan.",
            wrongExample = "aktipitas, kwalitas, sistim, tehnik, nasehat",
            rightExample = "aktivitas, kualitas, sistem, teknik, nasihat"
        )
    )

    val builderTemplates: List<TextBuilderTemplate> = listOf(
        TextBuilderTemplate(
            id = "build_lho",
            textType = "Teks Laporan Hasil Observasi",
            description = "Susun laporan pengamatan objek di sekitar sekolah atau rumah secara runtut dan objektif.",
            fields = listOf(
                BuilderField("judul", "Judul / Objek Observasi", "Contoh: Tanaman Lidah Buaya di Kebun Sekolah", "Tanaman Lidah Buaya (Aloe vera)"),
                BuilderField("umum", "1. Pernyataan Umum (Definisi & Klasifikasi)", "Jelaskan apa objek itu menggunakan kata 'adalah' atau 'merupakan'.", "Lidah buaya (Aloe vera) adalah tanaman sukulen berdaun tebal yang tumbuh subur di iklim tropis seperti Indonesia."),
                BuilderField("bagian", "2. Deskripsi Bagian (Ciri Fisik Nyata)", "Uraikan warna, ukuran, tekstur, atau bagian objek berdasarkan pengamatan.", "Daunnya berwarna hijau segar, meruncing di ujung dengan tepi bergerigi halus, serta berisi gel bening di bagian dalam."),
                BuilderField("manfaat", "3. Deskripsi Manfaat", "Tuliskan kegunaan objek bagi manusia atau lingkungan.", "Gel lidah buaya bermanfaat untuk meredakan luka bakar ringan, melembapkan kulit, serta diolah menjadi minuman sehat.")
            )
        ),
        TextBuilderTemplate(
            id = "build_anekdot",
            textType = "Teks Anekdot",
            description = "Rangkai cerita singkat yang menghibur sekaligus menyindir kebiasaan sehari-hari secara santun.",
            fields = listOf(
                BuilderField("judul", "Judul Anekdot", "Contoh: Jam Karet yang Elastis", "Jam Karet di Rapat Kelas"),
                BuilderField("orientasi", "1. Abstraksi & Orientasi (Latar & Tokoh)", "Siapa tokohnya dan di mana kejadian berlangsung?", "Pagi itu ruang kelas X-3 sudah ramai karena jadwal rapat panitia pentas seni dimulai pukul 08.00."),
                BuilderField("krisis", "2. Krisis (Kejanggalan / Sindiran)", "Masukkan dialog atau peristiwa kocak yang menyindir masalah.", "Namun baru tiga orang datang. Ketua panitia yang datang pukul 09.15 berkata santai, 'Tenang, namanya juga jam karet, kalau tidak ditarik ya tidak mulur.'"),
                BuilderField("koda", "3. Reaksi & Koda (Tanggapan & Penutup)", "Bagaimana respons tokoh lain dan pesan penutupnya?", "Semua pun tertawa kecut, lalu sepakat memasang pengingat bersama agar rapat berikutnya benar-benar dimulai tepat waktu.")
            )
        ),
        TextBuilderTemplate(
            id = "build_negosiasi",
            textType = "Dialog Teks Negosiasi",
            description = "Latih keterampilan berkomunikasi persuasif untuk mencapai kesepakatan win-win.",
            fields = listOf(
                BuilderField("judul", "Topik Negosiasi", "Contoh: Permohonan Perubahan Jadwal Pengumpulan Tugas", "Negosiasi Tenggat Majalah Dinding"),
                BuilderField("orientasi", "1. Orientasi & Pengajuan", "Sapa dengan santun dan sampaikan usulan awal beserta alasan.", "Siswa: 'Selamat siang, Bu. Kami dari tim mading izin mengajukan perpanjangan waktu pengumpulan hingga Jumat karena perlu memverifikasi wawancara narasumber.'"),
                BuilderField("penawaran", "2. Penawaran & Kompromi", "Tawarkan jalan tengah apabila ada kendala dari pihak lain.", "Guru: 'Jumat terlalu mepet untuk penilaian. Bagaimana jika draf artikel masuk Kamis siang, lalu tata letaknya menyusul Jumat pagi?'"),
                BuilderField("persetujuan", "3. Persetujuan", "Tegaskan kesepakatan bersama yang menguntungkan kedua pihak.", "Siswa: 'Baik, Bu, kami sepakat! Kamis siang draf teks akan kami serahkan lengkap, dan Jumat pagi mading siap dipajang.'")
            )
        ),
        TextBuilderTemplate(
            id = "build_puisi",
            textType = "Draf Puisi Pendek",
            description = "Tuangkan perasaan atau pengamatan alam menjadi bait puisi dengan diksi dan imaji yang kuat.",
            fields = listOf(
                BuilderField("judul", "Judul Puisi", "Contoh: Hujan di Halaman Perpustakaan", "Hujan di Beranda Kelas"),
                BuilderField("bait1", "Bait 1 (Imaji Penglihatan / Pendengaran)", "Gambarkan suasana nyata tanpa langsung menyebut kata sifat klise.", "Rintik sore mengetuk atap seng sekolah,\nawan kelabu melipat sisa terik di lapangan,"),
                BuilderField("bait2", "Bait 2 (Majas & Perasaan)", "Gunakan metafora atau personifikasi untuk menyampaikan pesan.", "sementara di balik jendela kaca,\nbuku terbuka menjaga hangatnya cita-cita."),
                BuilderField("bait3", "Bait 3 (Penutup / Amanat)", "Tutup dengan larik yang berkesan.", "Esok pagi, halaman basah ini akan kembali menumbuhkan langkah baru.")
            )
        )
    )

    val quizTopics: List<QuizTopic> = listOf(
        QuizTopic(
            id = "kebahasaan",
            title = "Kaidah Kebahasaan & EYD V",
            subtitle = "Kalimat efektif, kata baku KBBI, dan ejaan tepat",
            badgeLabel = "Tata Bahasa",
            estimatedMinutes = 4
        ),
        QuizTopic(
            id = "sastra",
            title = "Apresiasi Sastra Kelas 10",
            subtitle = "Puisi, Anekdot, Cerpen, dan Hikayat Nusantara",
            badgeLabel = "Sastra",
            estimatedMinutes = 5
        ),
        QuizTopic(
            id = "nonsastra",
            title = "Penalaran Teks Non-Sastra",
            subtitle = "Laporan Observasi, Negosiasi, Biografi, dan Opini",
            badgeLabel = "Non-Sastra",
            estimatedMinutes = 5
        ),
        QuizTopic(
            id = "pengetahuan_umum",
            title = "Literasi & Pengetahuan Umum",
            subtitle = "Sejarah bahasa, cek fakta digital, dan wawasan Nusantara",
            badgeLabel = "Umum",
            estimatedMinutes = 4
        )
    )

    val allQuizQuestions: List<QuizQuestion> = listOf(
        // Kebahasaan & EYD V (5 questions)
        QuizQuestion(
            id = "k_1",
            topicId = "kebahasaan",
            question = "Manakah penulisan kalimat berikut yang paling sesuai dengan kaidah EYD V dan KBBI?",
            options = listOf(
                "Para hadirin sekalian dimohon berdiri sejenak.",
                "Apotek di dekat sekolah menyediakan jadwal praktek dokter.",
                "Risiko keterlambatan tugas dapat ditekan dengan manajemen waktu yang baik.",
                "Ibu membeli buah-buahan disebuah pasar tradisional."
            ),
            correctIndex = 2,
            explanation = "'Risiko' adalah kata baku. Kalimat A boros ('para hadirin sekalian'), B salah kata baku ('praktek' seharusnya 'praktik'), dan D salah spasi kata depan ('disebuah' seharusnya 'di sebuah')."
        ),
        QuizQuestion(
            id = "k_2",
            topicId = "kebahasaan",
            question = "Penulisan gabungan kata 'di' yang TEPAT ditunjukkan pada pilihan...",
            options = listOf(
                "dikelas dan di tulis",
                "di kelas dan ditulis",
                "di kelas dan di tulis",
                "dikelas dan ditulis"
            ),
            correctIndex = 1,
            explanation = "'di kelas' memakai kata depan penunjuk tempat sehingga dipisah; 'ditulis' merupakan imbuhan kata kerja pasif sehingga digabung."
        ),
        QuizQuestion(
            id = "k_3",
            topicId = "kebahasaan",
            question = "Kata baku yang tepat untuk melengkapi kalimat: 'Tim OSIS menyusun ... kegiatan sebelum melakukan ... hasil survei.' adalah...",
            options = listOf(
                "jadual, analisa",
                "jadwal, analisis",
                "jadual, analisis",
                "jadwal, analisa"
            ),
            correctIndex = 1,
            explanation = "Menurut KBBI, bentuk baku yang benar adalah 'jadwal' dan 'analisis'."
        ),
        QuizQuestion(
            id = "k_4",
            topicId = "kebahasaan",
            question = "Perhatikan kalimat: 'Kepada seluruh siswa kelas X harap mengumpulkan formulir literasi.' Mengapa kalimat tersebut tidak efektif?",
            options = listOf(
                "Karena tidak memiliki keterangan waktu",
                "Karena pemakaian kata depan 'kepada' di awal membuat subjek kalimat hilang",
                "Karena kata 'seluruh' seharusnya diganti 'para-para'",
                "Karena kalimat tersebut terlalu pendek"
            ),
            correctIndex = 1,
            explanation = "Kehadiran kata depan 'kepada' di depan frasa 'seluruh siswa kelas X' mengubahnya menjadi keterangan sehingga kalimat tidak bersubjek."
        ),
        QuizQuestion(
            id = "k_5",
            topicId = "kebahasaan",
            question = "Penggunaan tanda koma yang tepat sesuai EYD V terdapat pada kalimat...",
            options = listOf(
                "Rina suka membaca cerpen tetapi adiknya gemar komik sains.",
                "Rina suka membaca cerpen, tetapi adiknya gemar komik sains.",
                "Rina suka membaca cerpen karena, ceritanya sangat menyentuh.",
                "Rina, suka membaca cerpen dan puisi."
            ),
            correctIndex = 1,
            explanation = "Sesuai EYD V, tanda koma wajib dipakai sebelum kata penghubung pertentangan intrakalimat seperti 'tetapi', 'melainkan', dan 'sedangkan'."
        ),

        // Sastra (5 questions)
        QuizQuestion(
            id = "s_1",
            topicId = "sastra",
            question = "Bagian struktur Teks Anekdot yang memuat puncak kejanggalan atau sindiran lucu disebut...",
            options = listOf("Orientasi", "Krisis", "Koda", "Abstraksi"),
            correctIndex = 1,
            explanation = "Krisis adalah inti Teks Anekdot tempat terjadinya hal ganjil, unik, atau sindiran tajam."
        ),
        QuizQuestion(
            id = "s_2",
            topicId = "sastra",
            question = "Berikut ini yang merupakan ciri khas karya sastra Hikayat adalah...",
            options = listOf(
                "Menggunakan bahasa gaul perkotaan dan berlatar masa depan",
                "Bersifat istana sentris, memuat unsur kemustahilan, dan banyak kata arkais",
                "Selalu berbentuk tabel pengamatan ilmiah",
                "Ditulis khusus untuk berita kriminal harian"
            ),
            correctIndex = 1,
            explanation = "Hikayat merupakan prosa Melayu klasik yang umumnya berlatar istana, mengandung kemustahilan/kesaktian, serta memakai kosakata arkais."
        ),
        QuizQuestion(
            id = "s_3",
            topicId = "sastra",
            question = "Larik puisi: 'Ombak berkejaran memeluk batu karang dengan sabar.' Citraan dan majas yang muncul pada larik tersebut adalah...",
            options = listOf(
                "Citraan pencecapan dan majas litotes",
                "Citraan penglihatan dan majas personifikasi",
                "Citraan penciuman dan majas ironi",
                "Citraan pendengaran dan majas paradoks"
            ),
            correctIndex = 1,
            explanation = "Pembaca membayangkan ombak bergerak (citraan penglihatan) yang seolah-olah bisa berkejaran dan memeluk dengan sabar seperti manusia (personifikasi)."
        ),
        QuizQuestion(
            id = "s_4",
            topicId = "sastra",
            question = "Kalimat 'Terimalah bingkisan kecil yang tak seberapa ini sebagai tanda terima kasih kami' menggunakan majas...",
            options = listOf("Hiperbola", "Litotes", "Sinisme", "Simile"),
            correctIndex = 1,
            explanation = "Litotes digunakan untuk merendahkan hati atau mengecilkan pemberian/kemampuan sendiri demi kesantunan."
        ),
        QuizQuestion(
            id = "s_5",
            topicId = "sastra",
            question = "Perbedaan utama antara Teks Anekdot dan teks humor biasa terletak pada...",
            options = listOf(
                "Panjang pendeknya jumlah kata",
                "Adanya pesan kritik sosial atau sindiran bermakna di balik kelucuan anekdot",
                "Penggunaan bahasa daerah di setiap kalimat",
                "Keharusan memiliki minimal lima tokoh utama"
            ),
            correctIndex = 1,
            explanation = "Humor semata-mata bertujuan menghibur, sedangkan anekdot memadukan kelucuan dengan kritik terhadap fenomena sosial/layanan publik."
        ),

        // Non-Sastra (5 questions)
        QuizQuestion(
            id = "n_1",
            topicId = "nonsastra",
            question = "Urutan struktur Teks Laporan Hasil Observasi (LHO) yang paling tepat adalah...",
            options = listOf(
                "Orientasi – Krisis – Reaksi – Koda",
                "Pernyataan Umum – Deskripsi Bagian – Deskripsi Manfaat",
                "Pengajuan – Penawaran – Persetujuan",
                "Orientasi – Kejadian Penting – Reorientasi"
            ),
            correctIndex = 1,
            explanation = "Teks LHO disusun mulai dari Pernyataan Umum/Klasifikasi, lalu Deskripsi Bagian, dan ditutup dengan Deskripsi Manfaat/Simpulan."
        ),
        QuizQuestion(
            id = "n_2",
            topicId = "nonsastra",
            question = "Mengapa penulis Teks LHO tidak dianjurkan menulis kalimat 'Menurut pendapat saya, bunga ini paling indah sedunia'?",
            options = listOf(
                "Karena kata 'bunga' termasuk kata tidak baku",
                "Karena Teks LHO harus bersifat objektif berdasarkan fakta pengamatan, bukan opini subjektif",
                "Karena kalimat tersebut terlalu panjang",
                "Karena Teks LHO hanya boleh memakai kalimat tanya"
            ),
            correctIndex = 1,
            explanation = "Ciri utama LHO adalah objektif, faktual, dan dapat diuji melalui pengamatan, bukan penilaian perasaan pribadi."
        ),
        QuizQuestion(
            id = "n_3",
            topicId = "nonsastra",
            question = "Dalam Teks Negosiasi, bagian ketika kedua pihak saling mengajukan alternatif jalan tengah disebut...",
            options = listOf("Orientasi", "Penawaran", "Koda", "Deskripsi Bagian"),
            correctIndex = 1,
            explanation = "Tahap Penawaran adalah inti proses tawar-menawar menuju titik temu sebelum mencapai Persetujuan."
        ),
        QuizQuestion(
            id = "n_4",
            topicId = "nonsastra",
            question = "Ciri kebahasaan yang sangat menonjol pada Teks Biografi untuk menggambarkan perilaku nyata tokoh adalah...",
            options = listOf(
                "Kata kerja tindakan (verba material) dan kata ganti orang ketiga",
                "Kata arkais dan kalimat perintah",
                "Majas sarkasme dan kata ganti orang pertama jamak",
                "Kalimat retoris dan dialog tawar-menawar"
            ),
            correctIndex = 0,
            explanation = "Biografi memakai sudut pandang orang ketiga (ia, beliau) serta kata kerja tindakan untuk menceritakan kiprah nyata tokoh."
        ),
        QuizQuestion(
            id = "n_5",
            topicId = "nonsastra",
            question = "Manakah kalimat negosiasi yang paling santun dan persuasif saat berdiskusi dengan petugas perpustakaan?",
            options = listOf(
                "Pokoknya saya harus meminjam lima buku hari ini juga!",
                "Aturan perpustakaan terlalu kaku dan menyusahkan siswa.",
                "Permisi Bu, karena tugas riset kelompok kami butuh referensi tambahan, apakah boleh kami meminjam empat buku dengan jaminan kartu pelajar?",
                "Terserah Ibu saja, saya tidak mau tahu caranya."
            ),
            correctIndex = 2,
            explanation = "Kalimat tersebut menyapa dengan santun, memberi alasan logis, dan menawarkan solusi jaminan yang bertanggung jawab."
        ),

        // Pengetahuan Umum (5 questions)
        QuizQuestion(
            id = "p_1",
            topicId = "pengetahuan_umum",
            question = "Faktor utama yang menjadikan Bahasa Melayu dipilih sebagai cikal bakal Bahasa Indonesia adalah...",
            options = listOf(
                "Karena telah menjadi bahasa perhubungan (lingua franca) dan bersifat demokratis tanpa tingkatan kasta kaku",
                "Karena merupakan bahasa dengan jumlah penutur terbanyak di Pulau Jawa",
                "Karena baru diciptakan pada tahun 1945",
                "Karena tidak pernah menyerap kosakata dari bahasa daerah lain"
            ),
            correctIndex = 0,
            explanation = "Bahasa Melayu telah lama dipakai dalam perdagangan antarwilayah Nusantara dan mudah dipelajari berbagai lapisan masyarakat."
        ),
        QuizQuestion(
            id = "p_2",
            topicId = "pengetahuan_umum",
            question = "Pada November 2023, lembaga internasional apa yang menetapkan Bahasa Indonesia sebagai salah satu bahasa resmi Sidang Umumnya?",
            options = listOf("WHO", "UNESCO", "FIFA", "IMF"),
            correctIndex = 1,
            explanation = "Konferensi Umum UNESCO ke-42 pada November 2023 menetapkan Bahasa Indonesia sebagai bahasa resmi Sidang Umum UNESCO."
        ),
        QuizQuestion(
            id = "p_3",
            topicId = "pengetahuan_umum",
            question = "Dalam metode cek fakta SIFT, huruf 'F' (Find better coverage) berarti...",
            options = listOf(
                "Menghapus foto dari galeri ponsel",
                "Mencari laporan pembanding dari media lain yang kredibel",
                "Membagikan berita secepat mungkin ke grup kelas",
                "Membuat judul baru yang lebih heboh"
            ),
            correctIndex = 1,
            explanation = "Find better coverage melatih kita memeriksa silang informasi dengan membandingkan liputan dari beberapa sumber tepercaya."
        ),
        QuizQuestion(
            id = "p_4",
            topicId = "pengetahuan_umum",
            question = "Sistem irigasi tradisional Bali yang diakui sebagai Warisan Budaya Dunia UNESCO dan berlandaskan Tri Hita Karana bernama...",
            options = listOf("Sasi", "Subak", "Teras", "Lumbung"),
            correctIndex = 1,
            explanation = "Subak adalah sistem pengairan sekaligus organisasi sosial petani tradisional di Bali yang diakui UNESCO sejak 2012."
        ),
        QuizQuestion(
            id = "p_5",
            topicId = "pengetahuan_umum",
            question = "Manakah sikap literasi digital yang paling tepat ketika menerima pesan berantai berbunyi 'Sebarkan sebelum dihapus!'?",
            options = listOf(
                "Segera meneruskan ke lima grup agar tidak ketinggalan berita",
                "Menganggapnya pasti benar karena dikirim oleh kerabat",
                "Berhenti sejenak (Stop) dan memeriksa sumber serta media kredibel karena kalimat mendesak sering menjadi ciri hoaks",
                "Menyalin teksnya dan mengganti tanggalnya"
            ),
            correctIndex = 2,
            explanation = "Kalimat pemicu kepanikan atau desakan menyebarkan cepat merupakan ciri khas disinformasi; selalu berhenti dan verifikasi terlebih dahulu."
        )
    )

    // Daily 10-second warm-up challenges shown on Beranda
    val dailyWarmUps: List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "warmup_1",
            topicId = "kebahasaan",
            question = "Mana penulisan yang baku menurut KBBI & EYD V?",
            options = listOf(
                "Sekedar analisa resiko di apotik",
                "Sekadar analisis risiko di apotek",
                "Sekadar analisa risiko di apotek",
                "Sekedar analisis resiko di apotik"
            ),
            correctIndex = 1,
            explanation = "Keempat kata bakunya adalah: sekadar, analisis, risiko, dan apotek."
        ),
        QuizQuestion(
            id = "warmup_2",
            topicId = "kebahasaan",
            question = "Pilih kalimat yang paling efektif (tidak boros kata):",
            options = listOf(
                "Para hadirin sekalian dimohon agar supaya duduk tenang.",
                "Hadirin dimohon duduk dengan tenang.",
                "Semua para hadirin dimohon duduk tenang.",
                "Bagi hadirin harap supaya duduk tenang."
            ),
            correctIndex = 1,
            explanation = "'Hadirin' sudah bermakna jamak (para tamu), sehingga tidak perlu ditambah 'para' atau 'sekalian'."
        ),
        QuizQuestion(
            id = "warmup_3",
            topicId = "sastra",
            question = "Larik 'Lampu kota berjaga menemani langkah pelajar pulang malam' bermajas...",
            options = listOf("Personifikasi", "Litotes", "Ironi", "Simile"),
            correctIndex = 0,
            explanation = "Benda mati ('lampu kota') diberi sifat manusia ('berjaga menemani')."
        )
    )
}
