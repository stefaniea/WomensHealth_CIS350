package com.example.womenshealth_cis350;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.ExpandableListContextMenuInfo;
import android.widget.TextView;
import android.widget.Toast;

public class BenefitsOfBreastfeeding extends ExpandableListActivity {
	
	ExpandableListAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.benefits);
		
		// Set up our adapter
        mAdapter = new MyExpandableListAdapter();
        setListAdapter(mAdapter);
        registerForContextMenu(getExpandableListView());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
    public boolean onContextItemSelected(MenuItem item) {
        ExpandableListContextMenuInfo info = (ExpandableListContextMenuInfo) item.getMenuInfo();
 
        String title = ((TextView) info.targetView).getText().toString();
        
        int type = ExpandableListView.getPackedPositionType(info.packedPosition);
        if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
            int groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition); 
            int childPos = ExpandableListView.getPackedPositionChild(info.packedPosition); 
            Toast.makeText(this, title + ": Child " + childPos + " clicked in group " + groupPos,
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (type == ExpandableListView.PACKED_POSITION_TYPE_GROUP) {
            int groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition); 
            Toast.makeText(this, title + ": Group " + groupPos + " clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        
        return false;
    }
	
	public class MyExpandableListAdapter extends BaseExpandableListAdapter {

		// Sample data set.  children[i] contains the children (String[]) for groups[i].
	    private String[] groups = { "People Names", "Dog Names", "Cat Names", "Fish Names" };
	    private String[][] children = {
	            { "Arnold", "Barry", "Chuck", "David" },
	            { "Ace", "Bandit", "Cha-Cha", "Deuce" },
	            { "Fluffy", "Snuggles" },
	            { "Goldy", "Bubbles" }
	    };
	    
	    public Object getChild(int groupPosition, int childPosition) {
	        return children[groupPosition][childPosition];
	    }

	    public long getChildId(int groupPosition, int childPosition) {
	        return childPosition;
	    }

	    public int getChildrenCount(int groupPosition) {
	        return children[groupPosition].length;
	    }

	    public TextView getGenericView() {
	        // Layout parameters for the ExpandableListView
	        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
	                ViewGroup.LayoutParams.FILL_PARENT, 64);

	        TextView textView = new TextView(BenefitsOfBreastfeeding.this);
	        textView.setLayoutParams(lp);
	        // Center the text vertically
	        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
	        // Set the text starting position
	        textView.setPadding(36, 0, 0, 0);
	        return textView;
	    }
	    
	    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
	            View convertView, ViewGroup parent) {
	        TextView textView = getGenericView();
	        textView.setText(getChild(groupPosition, childPosition).toString());
	        return textView;
	    }

	    public Object getGroup(int groupPosition) {
	        return groups[groupPosition];
	    }

	    public int getGroupCount() {
	        return groups.length;
	    }

	    public long getGroupId(int groupPosition) {
	        return groupPosition;
	    }

	    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
	            ViewGroup parent) {
	        TextView textView = getGenericView();
	        textView.setText(getGroup(groupPosition).toString());
	        return textView;
	    }

	    public boolean isChildSelectable(int groupPosition, int childPosition) {
	        return true;
	    }

	    public boolean hasStableIds() {
	        return true;
	    }
	}
	
}
