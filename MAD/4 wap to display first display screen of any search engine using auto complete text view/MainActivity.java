public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView searchBar = findViewById(R.id.searchBar);
        
        // Sample search suggestions
        String[] suggestions = {"Android", "Apple", "Banana", "Cherry", "Date"};
        
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_dropdown_item_1line,
            suggestions
        );
        
        searchBar.setAdapter(adapter);
        searchBar.setThreshold(1); // Show suggestions after 1 character
        
        searchBar.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                Toast.makeText(this, "Searching: " + v.getText(), Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });
    }
}