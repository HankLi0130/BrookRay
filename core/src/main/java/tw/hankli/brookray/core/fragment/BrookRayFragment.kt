package tw.hankli.brookray.core.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.annotation.LayoutRes
import androidx.annotation.MenuRes
import androidx.fragment.app.Fragment
import tw.hankli.brookray.core.constant.NO_RESOURCE

abstract class BrookRayFragment : Fragment {

    constructor() : super()

    constructor(@LayoutRes layoutRes: Int) : super(layoutRes)

    constructor(
        @LayoutRes layoutId: Int,
        @MenuRes menuRes: Int = NO_RESOURCE
    ) : super(layoutId) {
        this.menuRes = menuRes
    }

    @MenuRes
    protected var menuRes = NO_RESOURCE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(menuRes != NO_RESOURCE)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        if (menuRes != NO_RESOURCE) inflater.inflate(menuRes, menu)
    }
}