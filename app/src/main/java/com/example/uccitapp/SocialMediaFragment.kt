import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.uccitapp.R

class SocialMediaFragment : Fragment() {

    companion object {
        private const val ARG_URL = "url"

        fun newInstance(url: String): SocialMediaFragment {
            val fragment = SocialMediaFragment()
            val args = Bundle()
            args.putString(ARG_URL, url)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_social_media, container, false)
        val webView = view.findViewById<WebView>(R.id.webView)
        webView.webViewClient = WebViewClient()
        val url = arguments?.getString(ARG_URL)
        webView.loadUrl(url ?: "")
        return view
    }
}
