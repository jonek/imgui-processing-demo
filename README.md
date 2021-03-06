# Demo

This demo shows how to use [imgui](https://github.com/ocornut/imgui) in a [Processing](https://processing.org) sketch.

This is how it looks like (click screenshot to see video):
[![Screencast](imgui-processing-demo-2019-03-09_10.26.27_preview.png)](https://raw.githubusercontent.com/jonek/imgui-processing-demo/master/imgui-processing-demo-2019-03-09_10.26.27.webm)

Currently, the imgui controls use a separate window.

## Dependencies

To make the imgui API accessible from the Java sketch this demo uses [jimgui](https://github.com/ice1000/jimgui).
Jimgui provides Java bindings for the native imgui.

## Help wanted!

I don't know how to show the imgui controls in the same window that is used by Processing.

If anybody knows how to access the main window in Processing (OpenGL) and how to tell imgui to use that one instead of opening a new separate window, please open an issue with suggestions.