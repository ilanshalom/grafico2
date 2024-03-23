package com.example.exemplografico2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

class MinhaView extends View {
    private int tipopaint=3;

    public MinhaView(Context cx, AttributeSet attrs) {
        super(cx, attrs);
        requestFocus();
        final Context viewContext = cx;

        setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(viewContext,
                        "\n\nVamos invalidar a tela, estado inicial.\n\n", Toast.LENGTH_LONG).show();
                tipopaint = 1;
                invalidate();
            }
        });

        setOnLongClickListener (new OnLongClickListener() {
            public boolean onLongClick(View v) {
                Toast.makeText(viewContext,
                        "\n\nVamos limpar a tela, sem pintar nada.\n\n", Toast.LENGTH_LONG).show();
                tipopaint = 2;
                invalidate();
                return true;
            }
        });
    }
    public void setTipoPaintv02(int i) {
        tipopaint=i;
    }

    @Override
    protected void onDraw(Canvas c) {
        Paint p = new Paint();
        p.setAntiAlias(true); //para suavizar as bordas (não o interior) do que será pintado

        switch (tipopaint) {
            case 1:
                ShapeDrawable fig1 = new ShapeDrawable(new RectShape());
                fig1.getPaint().setColor(0xFFDDFF00);
                //Obs.: setBounds(int left, int top, int right, int bottom)
                fig1.setBounds(0,0,30,50);

                OvalShape ov;
                ov = new OvalShape();
                ShapeDrawable fig2 = new ShapeDrawable(ov);
                fig2.getPaint().setColor(0x44DD44FF);

                //Obs.: getWidth() e getHeight() são valores relativos à área da View gráfica
                fig2.setBounds(0,60,getWidth(),getHeight());

                fig1.draw(c);
                fig2.draw(c);
                break;
            case 2:
                p.setColor(0xFFCCCCCC); //cinza
                c.drawRect(3,3,getWidth()-6, getHeight(), p);
                p.setColor(0xFF0000FF); //azul
                c.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2.6f-getWidth()/10, p);
                p.setColor(0xFFFF0000); //vermelho
                c.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2.6f-getWidth()/8, p);
                p.setColor(0xFF00FF00); //verde
                c.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2.6f-getWidth()/6, p);
                p.setColor(0xFFFFFF00); //amarelo
                c.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2.6f-getWidth()/4, p);
                break;
            case 3:
                //alguma lógica
                break;
            case 4:
                p.setColor(0xFFCCCCCC);
                c.drawRect(0, 0, getWidth(), getHeight(), p);
                p.setColor(0xFF0000FF);
                c.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2.6f-getWidth()/10, p);
                p.setColor(0xFF00FF00);
                c.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2.6f-getWidth()/8, p);
                p.setColor(0xFFFFFF00);
                c.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2.6f-getWidth()/6, p);
                p.setColor(0xFFFF0000);
                c.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2.6f-getWidth()/4, p);
                p.setColor(0xFF000000);
                c.drawLine(0, 0 , getWidth(), getHeight(), p);
                c.drawLine(0, getHeight() , getWidth(), 0, p);
                break;
            case 5:
                p.setColor(0xFFCCCCCC);
                c.drawRect(0,0, getWidth(), getHeight(), p);
                p.setColor(0xFFFFFF00);
                c.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2.6f-getWidth()/10, p);
                p.setColor(0xFF00FF00);
                c.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2.6f-getWidth()/8, p);
                p.setColor(0xFF0000FF);
                c.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2.6f-getWidth()/6, p);
                p.setColor(0xFFFF0000);
                c.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2.6f-getWidth()/4, p);
                p.setColor(0xFF000000);
                c.drawLine(0, 0 , getWidth(), getHeight(), p);
                c.drawLine(0, getHeight() , getWidth(), 0, p);
                break;

        } //switch
    }

}
