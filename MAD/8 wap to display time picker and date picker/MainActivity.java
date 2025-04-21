public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.btn).setOnClickListener(v -> {
            new DatePickerDialog(this, (d, y, m, d) -> 
                new TimePickerDialog(this, (t, h, m) -> 
                    Toast.makeText(this, d+"/"+(m+1)+"/"+y+" "+h+":"+m, Toast.LENGTH_SHORT).show(),
                    Calendar.getInstance().get(Calendar.HOUR),
                    Calendar.getInstance().get(Calendar.MINUTE),
                    true).show(),
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)).show();
        });
    }
}