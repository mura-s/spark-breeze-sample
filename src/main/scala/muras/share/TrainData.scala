package muras.share

/**
  * 訓練データ
  */
case class TrainData(
  label: Double,      // 正解ラベル (0.0: クリックしていない, 1.0: クリックした)
  uid: String,        // cookie等のuid
  hour: Int,          // 広告接触した時間 (0 〜 23)
  advertiserId: Int,  // 広告主ID (1 〜 10)
  campaignId: Int,    // キャンペーンID (1 〜 50)
  adId: Int,          // 広告ID (1 〜 100)
  siteId: Int,        // サイトID (1 〜 100)
  c1: Int,            // anonymized categorical variable1 (1 〜 100)
  c2: Int,            // anonymized categorical variable2 (1 〜 100)
  n1: Double,         // anonymized numerical variable1
  n2: Double          // anonymized numerical variable2
)

