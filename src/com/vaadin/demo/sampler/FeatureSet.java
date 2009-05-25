package com.vaadin.demo.sampler;

import java.util.Collections;
import java.util.LinkedList;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.demo.sampler.features.accordions.AccordionDisabled;
import com.vaadin.demo.sampler.features.accordions.AccordionIcons;
import com.vaadin.demo.sampler.features.blueprints.ProminentPrimaryAction;
import com.vaadin.demo.sampler.features.buttons.ButtonLink;
import com.vaadin.demo.sampler.features.buttons.ButtonPush;
import com.vaadin.demo.sampler.features.buttons.ButtonSwitch;
import com.vaadin.demo.sampler.features.commons.Errors;
import com.vaadin.demo.sampler.features.commons.Icons;
import com.vaadin.demo.sampler.features.commons.Tooltips;
import com.vaadin.demo.sampler.features.commons.Validation;
import com.vaadin.demo.sampler.features.dates.DateInline;
import com.vaadin.demo.sampler.features.dates.DateLocale;
import com.vaadin.demo.sampler.features.dates.DatePopup;
import com.vaadin.demo.sampler.features.dates.DateResolution;
import com.vaadin.demo.sampler.features.form.FormBasic;
import com.vaadin.demo.sampler.features.layouts.ApplicationLayout;
import com.vaadin.demo.sampler.features.layouts.CustomLayouts;
import com.vaadin.demo.sampler.features.layouts.ExpandingComponent;
import com.vaadin.demo.sampler.features.layouts.GridLayoutBasic;
import com.vaadin.demo.sampler.features.layouts.HorizontalLayoutBasic;
import com.vaadin.demo.sampler.features.layouts.LayoutAlignment;
import com.vaadin.demo.sampler.features.layouts.LayoutMargin;
import com.vaadin.demo.sampler.features.layouts.LayoutSpacing;
import com.vaadin.demo.sampler.features.layouts.SplitPanelBasic;
import com.vaadin.demo.sampler.features.layouts.VerticalLayoutBasic;
import com.vaadin.demo.sampler.features.layouts.WebLayout;
import com.vaadin.demo.sampler.features.link.LinkCurrentWindow;
import com.vaadin.demo.sampler.features.link.LinkNoDecorations;
import com.vaadin.demo.sampler.features.link.LinkSizedWindow;
import com.vaadin.demo.sampler.features.notifications.NotificationCustom;
import com.vaadin.demo.sampler.features.notifications.NotificationError;
import com.vaadin.demo.sampler.features.notifications.NotificationHumanized;
import com.vaadin.demo.sampler.features.notifications.NotificationTray;
import com.vaadin.demo.sampler.features.notifications.NotificationWarning;
import com.vaadin.demo.sampler.features.panels.PanelBasic;
import com.vaadin.demo.sampler.features.panels.PanelLight;
import com.vaadin.demo.sampler.features.selects.ComboBoxContains;
import com.vaadin.demo.sampler.features.selects.ComboBoxInputPrompt;
import com.vaadin.demo.sampler.features.selects.ComboBoxNewItems;
import com.vaadin.demo.sampler.features.selects.ComboBoxPlain;
import com.vaadin.demo.sampler.features.selects.ComboBoxStartsWith;
import com.vaadin.demo.sampler.features.selects.ListSelectMultiple;
import com.vaadin.demo.sampler.features.selects.ListSelectSingle;
import com.vaadin.demo.sampler.features.selects.NativeSelection;
import com.vaadin.demo.sampler.features.selects.TwinColumnSelect;
import com.vaadin.demo.sampler.features.table.TableActions;
import com.vaadin.demo.sampler.features.table.TableCellStyling;
import com.vaadin.demo.sampler.features.table.TableColumnAlignment;
import com.vaadin.demo.sampler.features.table.TableColumnCollapsing;
import com.vaadin.demo.sampler.features.table.TableColumnHeaders;
import com.vaadin.demo.sampler.features.table.TableColumnReordering;
import com.vaadin.demo.sampler.features.table.TableHeaderIcons;
import com.vaadin.demo.sampler.features.table.TableLazyLoading;
import com.vaadin.demo.sampler.features.table.TableMouseEvents;
import com.vaadin.demo.sampler.features.table.TableRowHeaders;
import com.vaadin.demo.sampler.features.table.TableRowStyling;
import com.vaadin.demo.sampler.features.table.TableSorting;
import com.vaadin.demo.sampler.features.tabsheets.TabSheetDisabled;
import com.vaadin.demo.sampler.features.tabsheets.TabSheetIcons;
import com.vaadin.demo.sampler.features.tabsheets.TabSheetScrolling;
import com.vaadin.demo.sampler.features.text.LabelPlain;
import com.vaadin.demo.sampler.features.text.LabelPreformatted;
import com.vaadin.demo.sampler.features.text.LabelRich;
import com.vaadin.demo.sampler.features.text.RichTextEditor;
import com.vaadin.demo.sampler.features.text.TextArea;
import com.vaadin.demo.sampler.features.text.TextFieldInputPrompt;
import com.vaadin.demo.sampler.features.text.TextFieldSecret;
import com.vaadin.demo.sampler.features.text.TextFieldSingle;
import com.vaadin.demo.sampler.features.trees.TreeActions;
import com.vaadin.demo.sampler.features.trees.TreeMouseEvents;
import com.vaadin.demo.sampler.features.trees.TreeMultiSelect;
import com.vaadin.demo.sampler.features.trees.TreeSingleSelect;
import com.vaadin.demo.sampler.features.windows.NativeWindow;
import com.vaadin.demo.sampler.features.windows.Subwindow;
import com.vaadin.demo.sampler.features.windows.SubwindowAutoSized;
import com.vaadin.demo.sampler.features.windows.SubwindowClose;
import com.vaadin.demo.sampler.features.windows.SubwindowModal;
import com.vaadin.demo.sampler.features.windows.SubwindowPositioned;
import com.vaadin.demo.sampler.features.windows.SubwindowSized;

/**
 * Contains the FeatureSet implementation and the structure for the feature
 * 'tree'.
 * <p>
 * Each set is implemented as it's own class to facilitate linking to sets in
 * the same way as linking to individual features.
 * </p>
 * 
 */
@SuppressWarnings("serial")
public class FeatureSet extends Feature {

    /*
     * MAIN structure; root is always a FeatureSet that is not shown
     */
    static final FeatureSet FEATURES = new FeatureSet("All", new Feature[] {
    // Main sets
            // new Blueprints(), disabled for now, until more samples are ready
            new Components(), //
            });

    /*
     * TOP LEVEL
     */
    public static class Blueprints extends FeatureSet {
        public Blueprints() {
            super("Blueprints", new Feature[] {
            // Blueprints
                    new ProminentPrimaryAction(), //
                    });
        }
    }

    public static class Components extends FeatureSet {
        public Components() {
            super("Components", new Feature[] {
            //
                    new Common(), //
                    new Accordions(), //
                    new Buttons(), //
                    new Dates(), //
                    new Forms(), // 
                    new Layouts(), //
                    new Links(), //
                    new Notifications(), //
                    new Panels(), //
                    new Selects(), //
                    new Tables(),//
                    new Tabsheets(), //
                    new Texts(), //
                    new TextFields(), //
                    new Trees(), //
                    new Windows(), //
            });
        }
    }

    /*
     * LEVEL 2
     */
    public static class Buttons extends FeatureSet {
        public Buttons() {
            super(
                    "Buttons",
                    "Buttons",
                    "A button is one of the fundamental building blocks of any application.",
                    new Feature[] {
                    //
                            new ButtonPush(), // basic
                            new ButtonLink(), // link
                            new ButtonSwitch(), // switch/checkbox

                    });
        }
    }

    public static class Links extends FeatureSet {
        public Links() {
            super(
                    "Links",
                    "Links",
                    "An external link. This is the basic HTML-style link, changing the url of the browser w/o triggering a server-side event (like the link-styled Button).",
                    new Feature[] {
                    //
                            new LinkCurrentWindow(), // basic
                            new LinkNoDecorations(), // new win
                            new LinkSizedWindow(), // new win

                    });
        }
    }

    public static class Notifications extends FeatureSet {
        public Notifications() {
            super(
                    "Notifications",
                    "Notifications",
                    "Notifications are lightweight informational messages, used to inform the user of various events.",
                    new Feature[] {
                    //
                            new NotificationHumanized(), // humanized
                            new NotificationWarning(), // warning
                            new NotificationTray(), // tray
                            new NotificationError(), // error
                            new NotificationCustom(), // error
                    });
        }
    }

    public static class Common extends FeatureSet {
        public Common() {
            super("Common", new Feature[] {
            //
                    new Tooltips(), // 
                    new Icons(), //
                    new Errors(), //
                    new Validation(), // TODO this should point to Form instead
            });
        }
    }

    public static class Selects extends FeatureSet {
        public Selects() {
            super("Selects", new Feature[] {
            //
                    new ListSelectSingle(), //  
                    new ListSelectMultiple(), //
                    new TwinColumnSelect(), //
                    new NativeSelection(), //
                    new ComboBoxPlain(), //
                    new ComboBoxInputPrompt(), //
                    new ComboBoxStartsWith(), //
                    new ComboBoxContains(), //
                    new ComboBoxNewItems(), //

            });
        }
    }

    public static class Layouts extends FeatureSet {
        public Layouts() {
            super(
                    "Layouts",
                    "Layouts",
                    "Making a usable, good looking, dynamic layout can be tricky, but with the right tools almost anything is possible.<br/>",
                    new Feature[] {
                    //
                            new LayoutMargin(), //
                            new LayoutSpacing(), //
                            new VerticalLayoutBasic(), //
                            new HorizontalLayoutBasic(), //
                            new GridLayoutBasic(), //
                            new LayoutAlignment(), //
                            new ExpandingComponent(), //
                            new SplitPanelBasic(), //
                            new ApplicationLayout(), //
                            new WebLayout(), //
                            new CustomLayouts(), //
                    });
        }
    }

    public static class Tabsheets extends FeatureSet {
        public Tabsheets() {
            super(
                    "Tabsheets",
                    "Tabsheets",
                    "A Tabsheet organizes multiple components so that only the one component associated with the currently selected 'tab' is shown. Typically a tab will contain a Layout, which in turn may contain many components.",
                    new Feature[] {
                    //        
                            new TabSheetIcons(), //
                            new TabSheetScrolling(), //
                            new TabSheetDisabled(), //
                    });
        }
    }

    public static class Accordions extends FeatureSet {
        public Accordions() {
            super(
                    "Accordions",
                    "Accordions",
                    "An accordion component is a specialized case of a tabsheet."
                            + " Within an accordion, the tabs are organized vertically,"
                            + " and the content will be shown directly below the tab.",
                    new Feature[] {
                    //        
                            new AccordionIcons(), //
                            new AccordionDisabled(), //
                    });
        }
    }

    public static class Panels extends FeatureSet {
        public Panels() {
            super(
                    "Panels",
                    "Panels",
                    "Panel is a simple container that supports scrolling.<br/>It's internal layout (by default VerticalLayout) can be configured or exchanged to get desired results. Components that are added to the Panel will in effect be added to the layout.",
                    new Feature[] {
                    //        
                            new PanelBasic(), //
                            new PanelLight(), //
                    });
        }
    }

    public static class Forms extends FeatureSet {
        public Forms() {
            super("Forms", "Forms",
                    "The Form -component provides a convenient way to organize"
                            + " related fields visually.", new Feature[] {
                    //        
                    new FormBasic(), //
                    });
        }
    }

    public static class Windows extends FeatureSet {
        public Windows() {
            super(
                    "Windows",
                    "Windows",
                    "Windows can (for instance) organize the UI, save space (popup windows), focus attention (modal windows), or provide multiple views for the same data for multitasking or dual screen setups (native browser windows).",
                    new Feature[] {
                    //        
                            new Subwindow(), //
                            new SubwindowModal(), //
                            new SubwindowAutoSized(), //
                            new SubwindowSized(), //
                            new SubwindowPositioned(), //
                            new SubwindowClose(), //
                            new NativeWindow(), // 
                    });
        }
    }

    public static class Tables extends FeatureSet {
        public Tables() {
            super(
                    "Table (Grid)",
                    "Table (Grid)",
                    "A Table, also known as a (Data)Grid, can be used to show data in a tabular fashion. It's well suited for showing large datasets.",
                    new Feature[] {
                    //        
                            new TableHeaderIcons(), //
                            new TableColumnHeaders(), //
                            new TableColumnReordering(), //
                            new TableColumnCollapsing(), //
                            new TableColumnAlignment(), //
                            new TableCellStyling(), //
                            new TableSorting(), //
                            new TableRowHeaders(), //
                            new TableRowStyling(), //
                            new TableActions(), //
                            new TableMouseEvents(), //
                            new TableLazyLoading(), //
                    });
        }
    }

    public static class Texts extends FeatureSet {
        public Texts() {
            super(
                    "Texts",
                    "Texts",
                    "A label is a simple component that allows you to add (optionally formatted) text components to your application.",
                    new Feature[] {
                    //      
                            new LabelPlain(), //
                            new LabelPreformatted(), //
                            new LabelRich(), //
                    });
        }
    }

    public static class TextFields extends FeatureSet {
        public TextFields() {
            super(
                    "TextFields",
                    "Text inputs",
                    "Text inputs are probably the most needed components in any application that require user input or editing.",
                    new Feature[] {
                    //      
                            new TextFieldSingle(), //
                            new TextFieldSecret(), //
                            new TextFieldInputPrompt(), //
                            new TextArea(), //
                            new RichTextEditor(), //
                    });
        }
    }

    public static class Trees extends FeatureSet {
        public Trees() {
            super(
                    "Trees",
                    "Trees",
                    "The Tree component provides a natural way to represent data that has hierarchical relationships, such as filesystems or message threads.",
                    new Feature[] {
                    //        
                            new TreeSingleSelect(), //
                            new TreeMultiSelect(), //
                            new TreeActions(), //
                            new TreeMouseEvents(), //
                    });
        }
    }

    public static class Dates extends FeatureSet {
        public Dates() {
            super(
                    "Dates",
                    "Dates",
                    "The DateField component can be used to produce various date and time input fields with different resolutions. The date and time format used with this component is reported to Vaadin by the browser.",
                    new Feature[] {
                    //        
                            new DatePopup(), //
                            new DateInline(), //
                            new DateLocale(), //
                            new DateResolution(), //
                    });
        }
    }

    // ----------------------------------------------------------
    /*
     * FeatureSet implementation follows.
     */

    private String pathname;

    private String name;

    private String desc;

    private String icon = "folder.gif";

    private Feature[] content;

    private HierarchicalContainer container = null;

    private boolean containerRecursive = false;

    FeatureSet(String pathname, Feature[] content) {
        this(pathname, pathname, "", content);
    }

    FeatureSet(String pathname, String name, Feature[] content) {
        this(pathname, name, "", content);
    }

    FeatureSet(String pathname, String name, String desc, Feature[] content) {
        this.pathname = pathname;
        this.name = name;
        this.desc = desc;
        this.content = content;
    }

    Feature[] getFeatures() {
        return content;
    }

    Feature getFeatureByPath(String path) {
        LinkedList<String> parts = new LinkedList<String>();
        Collections.addAll(parts, path.split("/"));
        FeatureSet f = this;
        while (f != null) {
            Feature[] fs = f.getFeatures();
            f = null; // break while if no new found
            String part = parts.remove(0);
            for (int i = 0; i < fs.length; i++) {
                if (fs[i].getPathName().equalsIgnoreCase(part)) {
                    if (parts.isEmpty()) {
                        return fs[i];
                    } else if (fs[i] instanceof FeatureSet) {
                        f = (FeatureSet) fs[i];
                        break;
                    } else {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    HierarchicalContainer getContainer(boolean recurse) {
        if (container == null || containerRecursive != recurse) {
            container = new HierarchicalContainer();
            container.addContainerProperty(PROPERTY_NAME, String.class, "");
            container.addContainerProperty(PROPERTY_DESCRIPTION, String.class,
                    "");
            // fill
            addFeatures(this, container, recurse);
        }
        return container;
    }

    private void addFeatures(FeatureSet f, HierarchicalContainer c,
            boolean recurse) {
        Feature[] features = f.getFeatures();
        for (int i = 0; i < features.length; i++) {
            Item item = c.addItem(features[i]);
            Property property = item.getItemProperty(PROPERTY_NAME);
            property.setValue(features[i].getName());
            property = item.getItemProperty(PROPERTY_DESCRIPTION);
            property.setValue(features[i].getDescription());
            if (recurse) {
                c.setParent(features[i], f);
                if (features[i] instanceof FeatureSet) {
                    addFeatures((FeatureSet) features[i], c, recurse);
                }
            }
            if (!(features[i] instanceof FeatureSet)) {
                c.setChildrenAllowed(features[i], false);
            }
        }
    }

    @Override
    public String getDescription() {
        return desc;
    }

    @Override
    public String getPathName() {
        return pathname;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getIconName() {
        return icon;
    }

    @Override
    public APIResource[] getRelatedAPI() {
        return null;
    }

    @Override
    public Class<? extends Feature>[] getRelatedFeatures() {
        return null;
    }

    @Override
    public NamedExternalResource[] getRelatedResources() {
        return null;
    }

}
